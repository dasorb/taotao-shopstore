/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-08-22 10:03:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class content_002dadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<link href=\"/js/kindeditor-4.1.10/themes/default/default.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"/js/kindeditor-4.1.10/kindeditor-all-min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"/js/kindeditor-4.1.10/lang/zh_CN.js\"></script>\n");
      out.write("<div style=\"padding:10px 10px 10px 10px\">\n");
      out.write("\t<form id=\"contentAddForm\" class=\"itemForm\" method=\"post\">\n");
      out.write("\t\t<input type=\"hidden\" name=\"categoryId\"/>\n");
      out.write("\t    <table cellpadding=\"5\">\n");
      out.write("\t        <tr>\n");
      out.write("\t            <td>内容标题:</td>\n");
      out.write("\t            <td><input class=\"easyui-textbox\" type=\"text\" name=\"title\" data-options=\"required:true\" style=\"width: 280px;\"></input></td>\n");
      out.write("\t        </tr>\n");
      out.write("\t        <tr>\n");
      out.write("\t            <td>内容子标题:</td>\n");
      out.write("\t            <td><input class=\"easyui-textbox\" type=\"text\" name=\"subTitle\" style=\"width: 280px;\"></input></td>\n");
      out.write("\t        </tr>\n");
      out.write("\t        <tr>\n");
      out.write("\t            <td>内容描述:</td>\n");
      out.write("\t            <td><input class=\"easyui-textbox\" name=\"titleDesc\" data-options=\"multiline:true,validType:'length[0,150]'\" style=\"height:60px;width: 280px;\"></input>\n");
      out.write("\t            </td>\n");
      out.write("\t        </tr>\n");
      out.write("\t         <tr>\n");
      out.write("\t            <td>URL:</td>\n");
      out.write("\t            <td><input class=\"easyui-textbox\" type=\"text\" name=\"url\" style=\"width: 280px;\"></input></td>\n");
      out.write("\t        </tr>\n");
      out.write("\t        <tr>\n");
      out.write("\t            <td>图片:</td>\n");
      out.write("\t            <td>\n");
      out.write("\t                <input type=\"hidden\" name=\"pic\" />\n");
      out.write("\t                <a href=\"javascript:void(0)\" class=\"easyui-linkbutton onePicUpload\">图片上传</a>\n");
      out.write("\t            </td>\n");
      out.write("\t        </tr>\n");
      out.write("\t        <tr>\n");
      out.write("\t            <td>图片2:</td>\n");
      out.write("\t            <td>\n");
      out.write("\t            \t<input type=\"hidden\" name=\"pic2\" />\n");
      out.write("\t            \t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton onePicUpload\">图片上传</a>\n");
      out.write("\t            </td>\n");
      out.write("\t        </tr>\n");
      out.write("\t        <tr>\n");
      out.write("\t            <td>内容:</td>\n");
      out.write("\t            <td>\n");
      out.write("\t                <textarea style=\"width:800px;height:300px;visibility:hidden;\" name=\"content\"></textarea>\n");
      out.write("\t            </td>\n");
      out.write("\t        </tr>\n");
      out.write("\t    </table>\n");
      out.write("\t</form>\n");
      out.write("\t<div style=\"padding:5px\">\n");
      out.write("\t    <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"contentAddPage.submitForm()\">提交</a>\n");
      out.write("\t    <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"contentAddPage.clearForm()\">重置</a>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tvar contentAddEditor ;\n");
      out.write("\t$(function(){\n");
      out.write("\t\tcontentAddEditor = TT.createEditor(\"#contentAddForm [name=content]\");\n");
      out.write("\t\tTT.initOnePicUpload();\n");
      out.write("\t\t$(\"#contentAddForm [name=categoryId]\").val($(\"#contentCategoryTree\").tree(\"getSelected\").id);\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\tvar contentAddPage  = {\n");
      out.write("\t\t\tsubmitForm : function (){\n");
      out.write("\t\t\t\tif(!$('#contentAddForm').form('validate')){\n");
      out.write("\t\t\t\t\t$.messager.alert('提示','表单还未填写完成!');\n");
      out.write("\t\t\t\t\treturn ;\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\tcontentAddEditor.sync();\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t$.post(\"/content/save\",$(\"#contentAddForm\").serialize(), function(data){\n");
      out.write("\t\t\t\t\tif(data.status == 200){\n");
      out.write("\t\t\t\t\t\t$.messager.alert('提示','新增内容成功!');\n");
      out.write("    \t\t\t\t\t$(\"#contentList\").datagrid(\"reload\");\n");
      out.write("    \t\t\t\t\tTT.closeCurrentWindow();\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\tclearForm : function(){\n");
      out.write("\t\t\t\t$('#contentAddForm').form('reset');\n");
      out.write("\t\t\t\tcontentAddEditor.html('');\n");
      out.write("\t\t\t}\n");
      out.write("\t};\n");
      out.write("</script>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
