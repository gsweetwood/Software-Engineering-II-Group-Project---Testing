/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }
   
   
   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String[] manualTestStrings = {"www.google.com", "google.com", "www.1.org", "https://www.site.com", "htp://www.internet.net",
			   "wwww.amazon.org", "https://en.wiki.org/science", "ftp://abc.gov", "https://www.abc!.eu", "ftp://www.qwerty.zz"};
	   for(String addr: manualTestStrings){
		   System.out.println("The result for " + addr + " is: " + urlVal.isValid(addr));
	   } 
	   
   }
   

   public void testSchemes()
   {
	   /* A valid URL scheme consists of a sequence of characters beginning with a letter and followed
	    * by any combination of letters, digit, plus (+), period (.), or hyphen(-). It is followed by
	    * a colon (:). 
	    * Ref: https://tools.ietf.org/html/rfc3986#section-3.1
	    */
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   ResultPair[] schemes = {new ResultPair("http:", true),
			   				   new ResultPair("https:", true),
			   				   new ResultPair("ftp:", true),
			   				   new ResultPair("irc:", true),
			   				   new ResultPair("file:", true),
			   				   new ResultPair("abc0+.-:", true),
			   				   new ResultPair("0abc+.-:", false),
			   				   new ResultPair(":ftp:", false),
			   				   new ResultPair("abc+.-+.-:", true),
			   				   new ResultPair("abcdefghijklmnopqrstuvwxyz0123456789+.-:", true)
	   };
	   
	   for (ResultPair scheme : schemes) {
		   String url = scheme.item + "//www.google.com";
		   assertEquals(url, scheme.valid, urlVal.isValid(url));		   
	   }
	   
   }
   
   public void testYourSecondPartition(){
	   
   }
   
   
   public void testIsValid()
   {
	   for(int i = 0;i<10000;i++)
	   {
		   
	   }
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}
