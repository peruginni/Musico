package cz.cvut.x33eja.macosond.business.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
public class Password
{
        /**
         * http://stackoverflow.com/questions/304268/using-java-to-get-a-files-md5-checksum
         */
        public static String encode(String clearTextPassword) throws NoSuchAlgorithmException
        {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(clearTextPassword.getBytes(),0,clearTextPassword.length());
                String signature = new BigInteger(1,md5.digest()).toString(16);
                return signature;
        }
}