/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gray.tutiontribe.interceptor;

import com.gray.tutiontribe.entity.User;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author grays
 */
@Interceptor
public class WelcomeEmailInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception {
        Object[] parameters = ic.getParameters();
        User user = (User) parameters[0];
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.mailtrap.io");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("b86e3548e7716b", "4de51409b3cba6");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("username"));//ur email
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("abc@gmail.com"));//u will send to
            message.setSubject("Hi Newbie");
            message.setContent(htmlWelcomePageSetter(user.getName()), "text/html");
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return ic.proceed();
    }

    private String htmlWelcomePageSetter(String name) {
        return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"width:100%;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\"> \n"
                + " <head> \n"
                + "  <meta charset=\"UTF-8\"> \n"
                + "  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \n"
                + "  <meta name=\"x-apple-disable-message-reformatting\"> \n"
                + "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \n"
                + "  <meta content=\"telephone=no\" name=\"format-detection\"> \n"
                + "  <title>New Template</title><!--[if (mso 16)]>\n"
                + "    <style type=\"text/css\">\n"
                + "    a {text-decoration: none;}\n"
                + "    </style>\n"
                + "    <![endif]--><!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--><!--[if gte mso 9]>\n"
                + "<xml>\n"
                + "    <o:OfficeDocumentSettings>\n"
                + "    <o:AllowPNG></o:AllowPNG>\n"
                + "    <o:PixelsPerInch>96</o:PixelsPerInch>\n"
                + "    </o:OfficeDocumentSettings>\n"
                + "</xml>\n"
                + "<![endif]--><!--[if !mso]><!-- --> \n"
                + "  <link href=\"https://fonts.googleapis.com/css?family=Lato:400,400i,700,700i\" rel=\"stylesheet\"><!--<![endif]--> \n"
                + "  <style type=\"text/css\">\n"
                + "#outlook a {\n"
                + "	padding:0;\n"
                + "}\n"
                + ".ExternalClass {\n"
                + "	width:100%;\n"
                + "}\n"
                + ".ExternalClass,\n"
                + ".ExternalClass p,\n"
                + ".ExternalClass span,\n"
                + ".ExternalClass font,\n"
                + ".ExternalClass td,\n"
                + ".ExternalClass div {\n"
                + "	line-height:100%;\n"
                + "}\n"
                + ".es-button {\n"
                + "	mso-style-priority:100!important;\n"
                + "	text-decoration:none!important;\n"
                + "}\n"
                + "a[x-apple-data-detectors] {\n"
                + "	color:inherit!important;\n"
                + "	text-decoration:none!important;\n"
                + "	font-size:inherit!important;\n"
                + "	font-family:inherit!important;\n"
                + "	font-weight:inherit!important;\n"
                + "	line-height:inherit!important;\n"
                + "}\n"
                + ".es-desk-hidden {\n"
                + "	display:none;\n"
                + "	float:left;\n"
                + "	overflow:hidden;\n"
                + "	width:0;\n"
                + "	max-height:0;\n"
                + "	line-height:0;\n"
                + "	mso-hide:all;\n"
                + "}\n"
                + "[data-ogsb] .es-button {\n"
                + "	border-width:0!important;\n"
                + "	padding:15px 25px 15px 25px!important;\n"
                + "}\n"
                + "[data-ogsb] .es-button.es-button-1 {\n"
                + "	padding:15px 30px!important;\n"
                + "}\n"
                + "@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120%!important } h1 { font-size:30px!important; text-align:center } h2 { font-size:26px!important; text-align:center } h3 { font-size:20px!important; text-align:center } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:30px!important } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:26px!important } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important } .es-menu td a { font-size:16px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:16px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:16px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:block!important } a.es-button, button.es-button { font-size:20px!important; display:block!important; border-width:15px 25px 15px 25px!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; max-height:inherit!important } }\n"
                + "</style> \n"
                + " </head> \n"
                + " <body data-new-gr-c-s-loaded=\"14.1079.0\" style=\"width:100%;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;padding:0;Margin:0\"> \n"
                + "  <div class=\"es-wrapper-color\" style=\"background-color:#F4F4F4\">\n"
                + "   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top\"> \n"
                + "     <tr class=\"gmail-fix\" height=\"0\" style=\"border-collapse:collapse\"> \n"
                + "     </tr> \n"
                + "     <tr style=\"border-collapse:collapse\"> \n"
                + "      <td valign=\"top\" style=\"padding:0;Margin:0\"> \n"
                + "       <table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:#8758FF;background-repeat:repeat;background-position:center top\"> \n"
                + "         <tr style=\"border-collapse:collapse\"> \n"
                + "          <td align=\"center\" style=\"padding:0;Margin:0\"> \n"
                + "           <table class=\"es-header-body\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"> \n"
                + "             <tr style=\"border-collapse:collapse\"> \n"
                + "              <td align=\"left\" style=\"Margin:0;padding-bottom:10px;padding-left:10px;padding-right:10px;padding-top:20px\"> \n"
                + "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n"
                + "                 <tr style=\"border-collapse:collapse\"> \n"
                + "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:580px\"> \n"
                + "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n"
                + "                     <tr style=\"border-collapse:collapse\">\n"
                + "                      </tr> \n"
                + "                   </table></td> \n"
                + "                 </tr> \n"
                + "               </table></td> \n"
                + "             </tr> \n"
                + "           </table></td> \n"
                + "         </tr> \n"
                + "       </table> \n"
                + "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n"
                + "         <tr style=\"border-collapse:collapse\"> \n"
                + "          <td style=\"padding:0;Margin:0;background-color:#8758FF\" bgcolor=\"#8758FF\" align=\"center\"> \n"
                + "           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \n"
                + "             <tr style=\"border-collapse:collapse\"> \n"
                + "              <td align=\"left\" style=\"padding:0;Margin:0\"> \n"
                + "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n"
                + "                 <tr style=\"border-collapse:collapse\"> \n"
                + "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\"> \n"
                + "                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;background-color:#ffffff;border-radius:4px\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" role=\"presentation\"> \n"
                + "                     <tr style=\"border-collapse:collapse\"> \n"
                + "                      <td align=\"center\" style=\"Margin:0;padding-bottom:5px;padding-left:30px;padding-right:30px;padding-top:35px\"><h1 style=\"Margin:0;line-height:58px;mso-line-height-rule:exactly;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;font-size:48px;font-style:normal;font-weight:normal;color:#111111\">Welcome!</h1></td> \n"
                + "                     </tr> \n"
                + "                     <tr style=\"border-collapse:collapse\"> \n"
                + "                      <td bgcolor=\"#ffffff\" align=\"center\" style=\"Margin:0;padding-top:5px;padding-bottom:5px;padding-left:20px;padding-right:20px;font-size:0\"> \n"
                + "                       <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n"
                + "                         <tr style=\"border-collapse:collapse\"> \n"
                + "                          <td style=\"padding:0;Margin:0;border-bottom:1px solid #ffffff;background:#FFFFFF none repeat scroll 0% 0%;height:1px;width:100%;margin:0px\"></td> \n"
                + "                         </tr> \n"
                + "                       </table></td> \n"
                + "                     </tr> \n"
                + "                   </table></td> \n"
                + "                 </tr> \n"
                + "               </table></td> \n"
                + "             </tr> \n"
                + "           </table></td> \n"
                + "         </tr> \n"
                + "       </table> \n"
                + "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n"
                + "         <tr style=\"border-collapse:collapse\"> \n"
                + "          <td align=\"center\" style=\"padding:0;Margin:0\"> \n"
                + "           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \n"
                + "             <tr style=\"border-collapse:collapse\"> \n"
                + "              <td align=\"left\" style=\"padding:0;Margin:0\"> \n"
                + "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n"
                + "                 <tr style=\"border-collapse:collapse\"> \n"
                + "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\"> \n"
                + "                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-radius:4px;background-color:#ffffff\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" role=\"presentation\"> \n"
                + "                     <tr style=\"border-collapse:collapse\"> \n"
                + "                      <td class=\"es-m-txt-l\" bgcolor=\"#ffffff\" align=\"left\" style=\"Margin:0;padding-top:20px;padding-bottom:20px;padding-left:30px;padding-right:30px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;line-height:27px;color:#666666;font-size:18px\">Hi " + name + " We're excited to have you get started. Stay tuned for more updates</p></td> \n"
                + "                     </tr>  \n"
                + "                     <tr style=\"border-collapse:collapse\"> \n"
                + "                      <td class=\"es-m-txt-l\" align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:30px;padding-right:30px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;line-height:27px;color:#666666;font-size:18px\">If you have any questions, just reply to this email—we're always happy to help out.</p></td> \n"
                + "                     </tr> \n"
                + "                     <tr style=\"border-collapse:collapse\"> \n"
                + "                      <td class=\"es-m-txt-l\" align=\"left\" style=\"Margin:0;padding-top:20px;padding-left:30px;padding-right:30px;padding-bottom:40px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;line-height:27px;color:#666666;font-size:18px\">Cheers,</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;line-height:27px;color:#666666;font-size:18px\">Team TutionTribe</p></td> \n"
                + "                     </tr> \n"
                + "                   </table></td> \n"
                + "                 </tr> \n"
                + "               </table></td> \n"
                + "             </tr> \n"
                + "           </table></td> \n"
                + "         </tr> \n"
                + "       </table> \n"
                + "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n"
                + "         <tr style=\"border-collapse:collapse\"> \n"
                + "          <td align=\"center\" style=\"padding:0;Margin:0\"> \n"
                + "           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \n"
                + "             <tr style=\"border-collapse:collapse\"> \n"
                + "              <td align=\"left\" style=\"padding:0;Margin:0\"> \n"
                + "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n"
                + "                 <tr style=\"border-collapse:collapse\"> \n"
                + "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\"> \n"
                + "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n"
                + "                     <tr style=\"border-collapse:collapse\"> \n"
                + "                      <td align=\"center\" style=\"Margin:0;padding-top:10px;padding-bottom:20px;padding-left:20px;padding-right:20px;font-size:0\"> \n"
                + "                       <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n"
                + "                         <tr style=\"border-collapse:collapse\"> \n"
                + "                          <td style=\"padding:0;Margin:0;border-bottom:1px solid #f4f4f4;background:#FFFFFF none repeat scroll 0% 0%;height:1px;width:100%;margin:0px\"></td> \n"
                + "                         </tr> \n"
                + "                       </table></td> \n"
                + "                     </tr> \n"
                + "                   </table></td> \n"
                + "                 </tr> \n"
                + "               </table></td> \n"
                + "             </tr> \n"
                + "           </table></td> \n"
                + "         </tr> \n"
                + "       </table> \n"
                + "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n"
                + "         <tr style=\"border-collapse:collapse\"> \n"
                + "          <td align=\"center\" style=\"padding:0;Margin:0\"> \n"
                + "           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \n"
                + "             <tr style=\"border-collapse:collapse\"> \n"
                + "              <td align=\"left\" style=\"padding:0;Margin:0\"> \n"
                + "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n"
                + "                 <tr style=\"border-collapse:collapse\">  \n"
                + "                 </tr> \n"
                + "               </table></td> \n"
                + "             </tr> \n"
                + "           </table></td> \n"
                + "         </tr> \n"
                + "       </table> \n"
                + "     </tr> \n"
                + "   </table> \n"
                + "  </div>  \n"
                + " </body>\n"
                + "</html>";
    }
}
