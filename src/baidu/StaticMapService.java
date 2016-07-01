

/**
 * StaticMapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */

    package baidu;

    /*
     *  StaticMapService java interface
     */

    public interface StaticMapService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getImg0
                
         */

         
                     public baidu.GetImgResponse getImg(

                        baidu.GetImg getImg0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getImg0
            
          */
        public void startgetImg(

            baidu.GetImg getImg0,

            final baidu.StaticMapServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    