/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.sample.inforecovery.controller;

import org.apache.axis2.context.ConfigurationContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.CarbonConstants;
import org.wso2.carbon.captcha.mgt.beans.xsd.CaptchaInfoBean;
import org.wso2.carbon.identity.mgt.stub.beans.VerificationBean;
import org.wso2.sample.inforecovery.client.UserInformationRecoveryClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class VerificationByEmailController extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(VerificationByEmailController.class);
    UserInformationRecoveryClient client;

    public void init() {
        try {
            ConfigurationContext configContext =
                    (ConfigurationContext) this.getServletContext().getAttribute(CarbonConstants.
                            CONFIGURATION_CONTEXT);
            String carbonServerUrl = this.getServletConfig().getServletContext()
                    .getInitParameter("carbonServerUrl");

            client = new UserInformationRecoveryClient(carbonServerUrl, configContext);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error(e.getMessage(), e);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,
            IOException {

        HttpSession session = req.getSession(true);
        String confirmation = req.getParameter("confirmation");
//		session.setAttribute("confirmation", confirmation);

        boolean verified = Boolean.parseBoolean((String) session.getAttribute("verify"));

        String viewPage = null;

        if (verified) {

            String username = req.getParameter("username");

            String carbonServerUrl = this.getServletConfig().getServletContext()
                    .getInitParameter("carbonServerUrl");

            String captchaPath = req.getParameter("captchaImagePath");
            String captchaKey = req.getParameter("captchaSecretKey");
            String captchaAnswer = req.getParameter("captchaAnswer");

            if (confirmation != null && session != null) {

                // verify conf code
                CaptchaInfoBean captchaInfoBean = new CaptchaInfoBean();
                captchaInfoBean.setImagePath(captchaPath);
                captchaInfoBean.setSecretKey(captchaKey);
                captchaInfoBean.setUserAnswer(captchaAnswer);
                VerificationBean verificationBean = null;

                verificationBean = client.verifyConfirmationCode(username, confirmation,
                        captchaInfoBean);

                if (verificationBean != null && verificationBean.getVerified()) {

                    session.setAttribute("confirmation", verificationBean.getKey());
                    session.setAttribute("username", username);
                    viewPage = "password_reset.jsp";

                } else {
                    req.setAttribute(
                            "errors",
                            "Invalid information provided. Either the user not found or captcha " +
                                    "answer is incorrect. Cannot proceed.");
                    viewPage = "error.jsp";
                }

            } else {

                req.setAttribute("errors",
                        "Missing confirmation code or invalid session. Cannot proceed.");
                session.setAttribute("verify", "false");
                viewPage = "error.jsp";
            }

        } else {

            CaptchaInfoBean captchaInfoBean;

            try {

                UserInformationRecoveryClient client = new UserInformationRecoveryClient();

                captchaInfoBean = client.generateCaptcha();

            } catch (Exception e) {
                return;
            }

            if (captchaInfoBean == null) {
                return;
            }

            String carbonServerUrl = this.getServletConfig().getServletContext()
                    .getInitParameter("carbonServerUrl");

            String captchaImagePath = captchaInfoBean.getImagePath();
            String captchaImageUrl = carbonServerUrl + "/" + captchaImagePath;
            String captchaSecretKey = captchaInfoBean.getSecretKey();

            req.setAttribute("captchaImageUrl", captchaImageUrl);
            req.setAttribute("captchaSecretKey", captchaSecretKey);
            req.setAttribute("captchaImagePath", captchaImagePath);

            req.setAttribute("validateAction", "validateByEmail");
            session.setAttribute("verify", "true");
            viewPage = "recover_request_info.jsp";
        }

        RequestDispatcher view = req.getRequestDispatcher(viewPage);
        view.forward(req, res);

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,
            IOException {

        doPost(req, res);
    }
}
