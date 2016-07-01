

/**
 * PlaceSuggestionService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */

    package baidu;

    /*
     *  PlaceSuggestionService java interface
     */

    public interface PlaceSuggestionService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getSuggestionJson0
                
         */

         
                     public baidu.GetSuggestionJsonResponse getSuggestionJson(

                        baidu.GetSuggestionJson getSuggestionJson0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getSuggestionJson0
            
          */
        public void startgetSuggestionJson(

            baidu.GetSuggestionJson getSuggestionJson0,

            final baidu.PlaceSuggestionServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    