package com.gefshoes.api.service;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import com.gefshoes.api.model.Mail;
import javax.mail.Transport;
import java.util.Properties;
import java.util.Random;

/**
 * Classe usada para envio de emails.
 *
 * @author João Guedes.
 */
@Service
public class MailService {

    private static final String EMAIL = "ecommercegefshoes@gmail.com";
    private static final String PASSWORD = "nklnwmydasasfisd";

    /**
     * Envia um email de recuperação da conta para um email destinatário.
     *
     * @param emailTo
     * 
     * @return Retorna o código gerada para recuperação.
     *
     * @throws MessagingException Lança uma exceção caso tenha alguma falha no envio
     * da mensagem.
     */
    public String sendRecoveryEmail(String emailTo) throws MessagingException {
        String recoveryCode = this.generateRecoveryCode();
        final String HTML_TEXT = """
                <!DOCTYPE html>
                <html lang="en">
                  <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
                    <style>
                      body {
                        font-family: "Roboto", sans-serif;
                        background-color: #ffffff;
                        margin: 0;
                        padding: 0;
                      }
                                
                      table {
                        border-collapse: separate;
                        margin: 0 auto;
                      }
                                
                      th,
                      td {
                        text-align: center;
                        padding: 15px;
                        color: #ffffff;
                      }
                                
                      a,
                      a:link,
                      a:hover {
                        text-decoration: none;
                      }
                                
                      h1,
                      h2 {
                        color: #4d4e65 !important;
                      }
                                
                      .email__template__apresentation {
                        background-color: #ffffff;
                      }
                                
                      .email__template__apresentation__img {
                        padding: 0;
                        padding-bottom: 10px;
                      }
                                
                      .email__template__link {
                        background-color: #753bfd0d;
                        padding: 10px, 47px, 10px, 47px;
                        border-radius: 45px;
                        max-width: 555px;
                        overflow: hidden;
                        text-overflow: ellipsis;
                        white-space: nowrap;
                      }
                                
                      .email__template__link__text {
                        color: #6200ee;
                      }
                                
                      .email__template__button {
                        padding: 6px, 6px, 6px, 8px;
                        text-align: center;
                        border-radius: 4px;
                        background-color: #080808;
                        width: 565px;
                      }
                                
                      .email__template__footer {
                        margin-top: 40px;
                      }
                                
                      .email__template__footer__text {
                        padding: 20px;
                        text-align: center;
                        color: #d0d2df;
                        border-top: 1px solid #dddddd;
                      }
                                
                      .email__template__footer__text__end {
                        border-top: 1px solid #dddddd;
                      }
                                
                      .ExternalClass {
                        width: 100%;
                      }
                    </style>
                    <title>GEFShoes: redefinição de senha</title>
                  </head>
                                
                  <body>
                    <table
                      class="email__template"
                      role="presentation"
                      width="100%"
                      cellspacing="0"
                      cellpadding="0"
                      border="0"
                    >
                      <tr>
                        <td align="center" style="padding: 20px">
                          <table
                            class="email__template__apresentation"
                            role="presentation"
                            width="600"
                            cellspacing="0"
                            cellpadding="0"
                          >
                            <tr>
                              <td class="email__template__apresentation__img">
                                <a
                                  ><img
                                    style="width: 80px"
                                    src="https://i.imgur.com/2OXLSyo.png"
                                    title="source: imgur.com"
                                /></a>
                              </td>
                            </tr>
                                
                            <tr>
                              <td style="border-top: 1px solid #dddddd">
                                <h1>Hey, você!</h1>
                                <p style="color: #4d4e65">
                                  Parece que você esqueceu sua senha. Para recuperar, utilize o
                                  <b>token abaixo:</b>
                                </p>
                              </td>
                            </tr>
                          </table>
                                
                          <table>
                            <tr>
                              <td class="email__template__link">
                                <a alt="Link" style="vertical-align: middle"
                                  ><img
                                    src="https://i.imgur.com/RiabXqQ.png"
                                    title="source: imgur.com"
                                /></a>
                                <a
                                  class="email__template__link__text"
                                  href="{{link}}"
                                  target="_blank"
                                  ><b>$recoveryCode</b></a
                                >
                              </td>
                            </tr>
                          </table>
                                
                          <table style="margin-top: 35px">
                            <tr>
                              <td class="email__template__button">
                                <a style="color: #ffffff" href="{{link}}" target="_blank"
                                  ><b>RECUPERE SUA SENHA</b></a
                                >
                              </td>
                            </tr>
                          </table>
                                
                          <table
                            class="email__template__footer"
                            role="presentation"
                            width="600"
                            cellspacing="0"
                            cellpadding="0"
                            border="0"
                          >
                            <tr>
                              <td class="email__template__footer__text">
                                <p style="font-size: 14px; height: 18px; color: #9494af">
                                  Se você não solicitou a recuperação de sua senha, ignore este
                                  e-mail.
                                </p>
                                <p style="font-size: 10px; color: #9494af; text-align: center">
                                  Para sua segurança, não encaminhe este e-mail para ninguém.<br />
                                  <br />
                                  Precisa de ajuda?<br />
                                  <br />
                                  Entre em contato com nossa equipe de suporte enviando um email
                                  para ecommercegefshoes@gmail.com<br />
                                  <br />
                                  Sobre GEFShoes | BR<br />
                                  <br />
                                
                                  GEFShoes é um e-commerce especializado em calçados esportivos
                                  e casuais, proporcionando conforto e estilo moderno aos seus
                                  clientes.
                                </p>
                              </td>
                            </tr>
                                
                            <table
                              style="margin-top: 20px"
                              ole="presentation"
                              width="600"
                              cellspacing="0"
                              cellpadding="0"
                              border="0"
                            >
                              <tr>
                                <td class="email__template__footer__text__end">
                                  <p style="font-size: 10px; color: #9494af">
                                    GEFShoes. Todos os direitos reservados.
                                  </p>
                                </td>
                              </tr>
                            </table>
                          </table>
                        </td>
                      </tr>
                    </table>
                  </body>
                </html>
                """.replace("$recoveryCode", recoveryCode);
        Mail mail = Mail.builder()
                .emailFrom(EMAIL)
                .ownerPassword(PASSWORD)
                .subject("Recuperação de conta")
                .emailTo(emailTo)
                .text(HTML_TEXT)
                .build();
        Session session = this.createSession(mail);
        Message message = this.createMessage(session, mail);
        Transport.send(message);
        return recoveryCode;
    }

    /**
     * Retorna um properties contento as informações de acesso ao servido do Google Gmail.
     *
     * @return Retorna um properties contento as informações de acesso ao servido do Google Gmail.
     */
    private Properties getProperties() {
        Properties props = new Properties();
        props.put ("mail.smtp.host", "smtp.gmail.com");
        props.put ("mail.smtp.port", "465");
        props.put ("mail.smtp.ssl.enable", "true");
        props.put ("mail.smtp.auth", "true");
        return props;
    }

    /**
     * Retorna uma sessão autenticada com o servidor do Google Gmail.
     * 
     * @param mail objeto que contém as informações do remetente.
     *
     * @return Retorna uma sessão autenticada com o servidor do Google Gmail.
     */
    private Session createSession(Mail mail) {
        Properties props = this.getProperties();
        Session session =  Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication () {
                return new PasswordAuthentication (mail.getEmailFrom(), mail.getOwnerPassword());
            }
        });
        session.setDebug (true);
        return session;
    }

    /**
     * Retorna uma mensagem ligada a conta de uma sessão e contendo um destinatário, um título e um corpo.
     *
     * @param mail objeto contendo as informações da mensagem.
     *
     * @return Retorna uma mensagem ligada a conta de uma sessão e contendo um destinatário, um título e um corpo.
     */
    private Message createMessage(Session session, Mail mail) {
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(mail.getEmailFrom()));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mail.getEmailTo()));
            msg.setSubject(mail.getSubject(), "UTF-8");
            msg.setContent(mail.getText(), "text/html; charset=UTF-8");
            return msg;
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to create message.");
        }
    }

    /**
     * Gera um código de recuperação aleatório.
     *
     * @return Retorna um código de recuperação aleatório.
     */
    private String generateRecoveryCode() {
        StringBuilder recoveryCode = new StringBuilder();
        Random random = new Random();
        char c;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                c = (char) random.nextInt(65, 91);
                recoveryCode.append(c);
            }
            if (i < 3) {
                recoveryCode.append("-");
            }
        }
        return recoveryCode.toString();
    }

}