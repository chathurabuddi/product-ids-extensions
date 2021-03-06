/*
 * An XML document type.
 * Localname: getAttachmentInfosResponse
 * Namespace: http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803
 * Java type: org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetAttachmentInfosResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.impl;
/**
 * A document containing one getAttachmentInfosResponse(@http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803) element.
 *
 * This is a complex type.
 */
public class GetAttachmentInfosResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetAttachmentInfosResponseDocument
{
    private static final long serialVersionUID = 1L;
    
    public GetAttachmentInfosResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETATTACHMENTINFOSRESPONSE$0 = 
        new javax.xml.namespace.QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803", "getAttachmentInfosResponse");
    
    
    /**
     * Gets the "getAttachmentInfosResponse" element
     */
    public org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetAttachmentInfosResponseDocument.GetAttachmentInfosResponse getGetAttachmentInfosResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetAttachmentInfosResponseDocument.GetAttachmentInfosResponse target = null;
            target = (org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetAttachmentInfosResponseDocument.GetAttachmentInfosResponse)get_store().find_element_user(GETATTACHMENTINFOSRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getAttachmentInfosResponse" element
     */
    public void setGetAttachmentInfosResponse(org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetAttachmentInfosResponseDocument.GetAttachmentInfosResponse getAttachmentInfosResponse)
    {
        generatedSetterHelperImpl(getAttachmentInfosResponse, GETATTACHMENTINFOSRESPONSE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "getAttachmentInfosResponse" element
     */
    public org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetAttachmentInfosResponseDocument.GetAttachmentInfosResponse addNewGetAttachmentInfosResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetAttachmentInfosResponseDocument.GetAttachmentInfosResponse target = null;
            target = (org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetAttachmentInfosResponseDocument.GetAttachmentInfosResponse)get_store().add_element_user(GETATTACHMENTINFOSRESPONSE$0);
            return target;
        }
    }
    /**
     * An XML getAttachmentInfosResponse(@http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803).
     *
     * This is a complex type.
     */
    public static class GetAttachmentInfosResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetAttachmentInfosResponseDocument.GetAttachmentInfosResponse
    {
        private static final long serialVersionUID = 1L;
        
        public GetAttachmentInfosResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName INFO$0 = 
            new javax.xml.namespace.QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803", "info");
        
        
        /**
         * Gets array of all "info" elements
         */
        public org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo[] getInfoArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(INFO$0, targetList);
                org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo[] result = new org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "info" element
         */
        public org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo getInfoArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo target = null;
                target = (org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo)get_store().find_element_user(INFO$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "info" element
         */
        public int sizeOfInfoArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(INFO$0);
            }
        }
        
        /**
         * Sets array of all "info" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setInfoArray(org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo[] infoArray)
        {
            check_orphaned();
            arraySetterHelper(infoArray, INFO$0);
        }
        
        /**
         * Sets ith "info" element
         */
        public void setInfoArray(int i, org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo info)
        {
            generatedSetterHelperImpl(info, INFO$0, i, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_ARRAYITEM);
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "info" element
         */
        public org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo insertNewInfo(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo target = null;
                target = (org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo)get_store().insert_element_user(INFO$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "info" element
         */
        public org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo addNewInfo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo target = null;
                target = (org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo)get_store().add_element_user(INFO$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "info" element
         */
        public void removeInfo(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(INFO$0, i);
            }
        }
    }
}
