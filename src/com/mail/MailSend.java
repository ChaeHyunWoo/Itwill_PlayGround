package com.mail;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class MailSend {
	
	private String receiverEmail;
	private String senderEmail;
	private String senderName;
	private String subject;
	private String content;
	
	private String fileFullPath;
	private String originalFileName;
	
	private String mailHost;
	private String mailType;
	
	
	public MailSend() {
		this.mailHost = "localhost";
		this.mailType = "text/html;charset=utf-8";
	}
	
	public MailSend(String mailHost) {
		this.mailHost = "localhost";
		this.mailType = "text/html;charset=utf-8";
	}
	
	
	public String getReceiverEmail() {
		return receiverEmail;
	}
	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileFullPath() {
		return fileFullPath;
	}
	public void setFileFullPath(String fileFullPath) {
		this.fileFullPath = fileFullPath;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getMailHost() {
		return mailHost;
	}
	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
	}
	public String getMailType() {
		return mailType;
	}
	public void setMailType(String mailType) {
		
		if(mailType.equalsIgnoreCase("text"))
			this.mailType = "text/plain;charset=UTF-8";
		else
			this.mailType = "text/html;charset=UTF-8";
	}
	
	public boolean sendMail() {
		
		
		try {
			
			Properties props = System.getProperties();
			//메일을 보내는 방식- 메일을 stmp방식으로 host에게 메일을 보낼 것이다.
			props.put("mail.smtp.host", mailHost); 
			
			Session session = Session.getDefaultInstance(props,null);
			
			//메일을 보낼  메세지 클래스 생성
			Message msg = new MimeMessage(session);
			
			//보내는사람
			if(senderName==null||senderName.equals("")) {
				msg.setFrom(new InternetAddress(senderEmail));
			}else {
				msg.setFrom(new InternetAddress(senderEmail,senderName,"UTF-8"));
			}
			
			
			//받는사람
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(receiverEmail));
			
			//제목
			msg.setSubject(subject);
			
			//HTML 형식인 경우 \r\n을 <br/>로 변환
			if(mailType.indexOf("text/html")!=-1) {
				content = content.replace("\r\n", "<br/>");
			}
			
			//메일내용과 파일을 MimeBodyPart로 나누어서 담음
			makeMessage(msg); //content
			
			msg.setHeader("X_Mailer", senderName);
			
			//메일보낸날짜
			msg.setSentDate(new Date());
			
			//메일전송
			Transport.send(msg);
			
			//메일전송후 파일삭제
			if(fileFullPath!=null) {
				
				File f = new File(fileFullPath);
				
				if(f.exists())
					f.delete(); //파일 삭제
				
				
				}
			
		} catch (MessagingException e) {
			System.out.println(e.toString());
			return false;
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
		return true;
		
		
	}
	
	
	//첨부파일이 있는경우 BodyPart로 나누어 분류하고 MultiMime로 파일을 전송한다
		private void makeMessage(Message msg) throws MessagingException{
			
			if(fileFullPath==null||fileFullPath.equals("")) {
				
				//파일을 첨부하지 않은 경우
				msg.setText(content);
				msg.setHeader("Content-Type", mailType);			
				
			}else {
				
				//파일을 첨부한 경우
				
				//메일내용
				MimeBodyPart mbp1 = new MimeBodyPart();
				mbp1.setText(content);
				mbp1.setHeader("Content-Type", mailType);
						
				
				//첨부파일
				MimeBodyPart mbp2 = new MimeBodyPart();
				FileDataSource fds = new FileDataSource(fileFullPath);
				
				mbp2.setDataHandler(new DataHandler(fds));
				
				try {
					
					if(originalFileName==null||originalFileName.equals("")) {					
						mbp2.setFileName(MimeUtility.encodeWord(fds.getName()));					
					}else {					
						mbp2.setFileName(MimeUtility.encodeWord(originalFileName));					
					}
					
					
				} catch (UnsupportedEncodingException e) {
					System.out.println(e.toString());
				}
				
				Multipart mp = new MimeMultipart();
				mp.addBodyPart(mbp1);
				mp.addBodyPart(mbp2);
				
				msg.setContent(mp);
				
			}
			
		}

	}
