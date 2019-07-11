package com.tomasjuan007.javalab.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


public class MixEncrypt{

	public String MixEncryptUtil(String username){

		String result = "";
		List<String> list = new ArrayList<String>();
		List<String> listmd = new ArrayList<String>();
		List<String> listsha = new ArrayList<String>();
		list.add(username);


		MD5Util md = new MD5Util();
		listmd.add(md.MD5(username));

		SHA1Util sha = new SHA1Util();
		listsha.add( sha.Encrypt(listmd.toString()));

		for(int i = 1 ; i<10; i++){

			listmd.add(md.MD5(listsha.toString()));

			if(listmd.size()>1){
				listmd.remove(0);
			}

			listsha.add( sha.Encrypt(listmd.toString()));

			if(listsha.size()>1){
				listsha.remove(0);
			}

		}
		result = listsha.toString();
		result = result.substring(1, result.length()-1);
		return result;
	}

	public String H_pass(String password){

		String result = "";
		List<String> list = new ArrayList<String>();
		list.add(password);

		SHA1Util sha = new SHA1Util();
		for(int i = 0 ; i < 20 ; i++){
			list.add( sha.Encrypt(list.toString()));
			if(list.size()>1){
				list.remove(0);
			}
		}
		result = list.toString();
		result = result.substring(1, result.length()-1);
		return result;
	}

	public String H_manager(String f_c_hash,String f_c_salt){

		String result = "";
		String hash4 = "";
		String str = "";
		String hash = "";
		int count = -1;
		List<String> fchash = new ArrayList<String>();
		List<String> hash_last10 = new ArrayList<String>();
		List<String> list = new ArrayList<String>();

		fchash.add(f_c_hash);

		str = fchash.toString();

		hash4 = str.substring(4, 5);
		hash = str.substring(str.length()-11, str.length()-1);
		System.out.println(str.substring(1, str.length()-1));
		System.out.println(hash);

		int hash41 = hash4.charAt(0);
		int hash42 = (int)hash41;
		int hash51 = hash4.charAt(0);
		int hash52 = (int) hash51;

		count = hash42*hash52;

		SHA1Util sha = new SHA1Util();

		for(int i = 0 ; i < count ; i++){
			list.add(sha.Encrypt(WordpressEncrypt(hash_last10.toString(),f_c_salt)));
			if(list.size()>1){
				list.remove(0);
			}
		}
		result = list.toString();
		result = result.substring(1, result.length()-1);
		return result;
	}

	public String WordpressEncrypt(String salt,String str){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] hash = md.digest((salt + str).getBytes());
			byte[] palin = str.getBytes();

			for(int i = 0;i < 8;i++){
				byte[] newplain = new byte[hash.length + palin.length];
				System.arraycopy(hash, 0, newplain, 0, hash.length);
				System.arraycopy(palin, 0, newplain, hash.length, palin.length);

				//MD5加密
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				hash = md5.digest(newplain);
			}

			int[] x = new int[hash.length];

			for(int i = 0;i < hash.length;i++){
				x[i] = hash[i] & 0xff;
			}
			//	System.out.println(re);
			//	return re;
			return "$P$B" + salt + encode64(x, 16);
			//	return String.valueOf(hash.length);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	private String encode64(int[] input, int number){
		String hash = "";
		int output = 0;
		int[] input_2 = new int[number];

		for (int i = 0; i < number; i++) {
			input_2[i] = input[i];
			//text_2.Text += "'" + input_2[i] + "'" ;
		}

		String itoa64 = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int output_2 = 0;
		int value_2 = 0;
		for (int i = 0; i <number;i++ ){
			int value = input_2[i];
			output = input_2[i];
			hash += itoa64.substring((value % 64 + 64)%64, (value % 64 + 64)%64 + 1);
			if (i + 1 <= number){
				if (i + 1 < number){
					value = input_2[++i];
					output_2 = (value << 8);//左移8位
					output = output + output_2;
				}

				value_2 = output;
				int len = Integer.toBinaryString(output).length();
				if (len - 6 > 0){
					output = (output >> 6);//右移6位
				} else {
					output = 0;
				}
				value = output;
				hash += itoa64.substring((value % 64 + 64)%64, (value % 64 + 64)%64 + 1);
			}else {
				break;
			}
			if (i + 1 < number){
				value = input_2[++i];
				output_2 = (value << 16);//左移16位
				output = value_2 + output_2;
				value_2 = output;
				output_2 = output;
				output = (output >> 12);//右移12位
				value = output;
				//                 hash += itoa64.substring((value % 64 + 64)%64, (value % 64 + 64)%64 + 1);
			}else{
				break;
			}
			if (i+1< number) {
				output = (output_2 >> 18);//右移18位
				value = output;
				//
				hash += itoa64.substring((value % 64 + 64)%64, (value % 64 + 64)%64 + 1);
			}
		}        return hash;
	}


	public class MD5Util {

		public final String MD5(String str) {
			// 用来将字节转换成 16 进制表示的字符
			char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			try {
				byte[] btInput = str.getBytes();
				// 获得MD5摘要算法的 MessageDigest 对象
				MessageDigest mdInst = MessageDigest.getInstance("MD5");
				// 使用指定的字节更新摘要
				mdInst.update(btInput);
				// 获得密文
				byte[] md = mdInst.digest();
				// 把密文转换成十六进制的字符串形式
				int j = md.length;
				char str1[] = new char[j * 2];// 每个字节用 16 进制表示的话，使用两个字符，
				// 所以表示成 16 进制需要 32 个字符
				int k = 0;// 表示转换结果中对应的字符位置
				for (int i = 0; i < j; i++) {// 从第一个字节开始，对 MD5 的每一个字节
					// 转换成 16 进制字符的转换
					byte byte0 = md[i];     // 取第 i 个字节
					// 取字节中高 4 位的数字转换,
					// >>> 为逻辑右移，将符号位一起右移
					str1[k++] = hexDigits[byte0 >>> 4 & 0xf];
					// 取字节中低 4 位的数字转换
					str1[k++] = hexDigits[byte0 & 0xf];
				}
				return new String(str1);// 换后的结果转换为字符串
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	public class SHA1Util{
		public String Encrypt(String strSrc) {

			MessageDigest md=null;
			String strDes=null;

			byte[] bt=strSrc.getBytes();
			try {

				md=MessageDigest.getInstance("SHA-1");
				md.update(bt);
				strDes=bytes2Hex(md.digest());  //to HexString
			}catch (NoSuchAlgorithmException e) {
				System.out.println("Invalid algorithm.");
				return null;
			}
			return strDes;
		}

		public String bytes2Hex(byte[]bts) {
			String des="";
			String tmp=null;
			for (int i=0;i<bts.length;i++) {
				tmp=(Integer.toHexString(bts[i] & 0xFF));
				if (tmp.length()==1) {
					des+="0";
				}
				des+=tmp;
			}
			return des;
		}
	}

	public static void main(String[] args) {
		MixEncrypt mixEncrypt = new MixEncrypt();
		System.out.println(mixEncrypt.MixEncryptUtil("hello"));
	}
}
