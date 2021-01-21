package com.col.domein.auction.model.vo;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Auctionemail implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//메일환경 변수 설정
			Properties props=new Properties();
			//매일 프로토콜은 gmail를 이용할것이기때문에 smtp로 사용합니다
			props.setProperty("mail.transport.protocol","smtp");
			props.setProperty("mail.host", "smtp.gmail.com");
			//id.password설정이 필요함
			props.put("mail.smtp.auth","true");
			props.put("mail.smtp.port","465");
			//ssl를 사용할 경우 설정합니다.
			props.put("mail.smtp.socketFactory.port","465");
			props.put("mail.smtp.socketFactory.fallback","false");
			props.setProperty("mail.smtp.quitwait","false");
			//id와 password를 설정하고 session을 생성합니다.
			Session session=Session.getDefaultInstance(props,new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("domein2020@gmail.com","colofduty2020");
				}
			});
			//디버그 모드 입니다.
			session.setDebug(true);
			//메일 메시지를 만들기위한 클래스 생성
			MimeMessage message=new MimeMessage(session);
			//송신자 설정
			message.setFrom(getAddress("domein2020@gmail.com"));
			//수신자 설정
			message.addRecipients(Message.RecipientType.TO,getAddresses("wlgns_82@naver.com"));
			//참조 수신자 설정
			message.addRecipients(Message.RecipientType.CC,getAddresses("domein2020@gmail.com"));
			//숨은 참조 수신자 설정
			message.addRecipients(Message.RecipientType.BCC,getAddresses("domein2020@gmail.com"));
			//메일 제목을 설정한다.
			message.setSubject("테스트 메일입니다.");
			//메일 내용 설정을 위한 클래스 
			message.setContent(new MimeMultipart());
			//메일 내용을 위한 Mutipart클래스를 받아온다 위에 
			Multipart mp=(Multipart) message.getContent();
			//html형식으로 본문을 작성해서 바둥ㄴ더리에 넣습니다.
			mp.addBodyPart(getContents("<hmtl><head></head><body>안녕하세요~<br></body></html>"));
			//첨부파일을 추가합니다.
			mp.addBodyPart(getFileAttachment("test.xlsx"));
			//이미지파일을 추가해서 conetextId를 설정한다.contextId는 위본문내용의 cid로 링크가 설정가능합니다.
			mp.addBodyPart(getImage("capture.png","image"));
			//메일을 보냅니다.
			Transport.send(message);
		
		
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	//메일의 본문 내용 설정
	private BodyPart getContents(String html) throws MessagingException{
		BodyPart mbp=new MimeBodyPart();
		//setText를 이용할 경우 일반 텍스트 내용으로 설정된다
		//mbp.setText(html);
		//html형식으로 설정
		mbp.setContent(html,"text/html; charset=utf-8");
		return mbp;
	}
	//파일을 로컬로 부터 읽어와서 BodyPart클래스로 만든다.(바운더리 변환)
	private BodyPart getImage(String filename,String contextId) throws MessagingException{
		BodyPart mbp=getFileAttachment(filename);
		if(contextId != null) {
			mbp.setHeader("Content-ID","<"+contextId+">");
		}
		return mbp;
	}
	//파일을 로컬로 부터 읽어와서 Bodypart클래스로 만든다(바운더리 변환)
	private BodyPart getFileAttachment(String filename) throws MessagingException{
		//BodyPart생성
		BodyPart mbp= new MimeBodyPart();
		//파일읽어서 bodyPart에 설정 (바운더리 변환)
		File file= new File(filename);
		DataSource source= new FileDataSource(file);
		mbp.setDataHandler(new DataHandler(source));
		mbp.setDisposition(Part.ATTACHMENT);
		mbp.setFileName(file.getName());
		return mbp;
	}
	//String 으로 된 메일 주소를 address클래스로 변환
	private Address getAddress(String address) throws AddressException {
		return new InternetAddress(address);
	}
	//String으로 된 복수의 메일 주소를 콤마(,)의 구분으로 Addressarray형태로 변환
	private Address[] getAddresses(String addresses)throws AddressException{
		String[] array=addresses.split(",");
		Address[] ret=new Address[array.length];//길이만큼 배열을 생성하고
		for(int i=0;i< ret.length;i++) {
			ret[i]=getAddress(array[i]);
		}
		return ret;
	}
	/*
	 * //시작 함수 Program을 생성해서 run을 실행합니다. public static void main(String[] args) {
	 * Auctionemail a = new Auctionemail(); 
	 * a.run(); }
	 */
}
