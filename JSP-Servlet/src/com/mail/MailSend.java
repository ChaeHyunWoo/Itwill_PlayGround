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
			//������ ������ ���- ������ stmp������� host���� ������ ���� ���̴�.
			props.put("mail.smtp.host", mailHost); 
			
			Session session = Session.getDefaultInstance(props,null);
			
			//������ ����  �޼��� Ŭ���� ����
			Message msg = new MimeMessage(session);
			
			//�����»��
			if(senderName==null||senderName.equals("")) {
				msg.setFrom(new InternetAddress(senderEmail));
			}else {
				msg.setFrom(new InternetAddress(senderEmail,senderName,"UTF-8"));
			}
			
			
			//�޴»��
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(receiverEmail));
			
			//����
			msg.setSubject(subject);
			
			//HTML ������ ��� \r\n�� <br/>�� ��ȯ
			if(mailType.indexOf("text/html")!=-1) {
				content = content.replace("\r\n", "<br/>");
			}
			
			//���ϳ���� ������ MimeBodyPart�� ����� ����
			makeMessage(msg); //content
			
			msg.setHeader("X_Mailer", senderName);
			
			//���Ϻ�����¥
			msg.setSentDate(new Date());
			
			//��������
			Transport.send(msg);
			
			//���������� ���ϻ���
			if(fileFullPath!=null) {
				
				File f = new File(fileFullPath);
				
				if(f.exists())
					f.delete(); //���� ����
				
				
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
	
	
	//÷�������� �ִ°�� BodyPart�� ������ �з��ϰ� MultiMime�� ������ �����Ѵ�
		private void makeMessage(Message msg) throws MessagingException{
			
			if(fileFullPath==null||fileFullPath.equals("")) {
				
				//������ ÷������ ���� ���
				msg.setText(content);
				msg.setHeader("Content-Type", mailType);			
				
			}else {
				
				//������ ÷���� ���
				
				//���ϳ���
				MimeBodyPart mbp1 = new MimeBodyPart();
				mbp1.setText(content);
				mbp1.setHeader("Content-Type", mailType);
						
				
				//÷������
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
