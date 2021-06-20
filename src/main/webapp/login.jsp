<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="tr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Kitap Satış Sitesi">
    <meta name="keywords" content="kitap,okumak,eğitim,roman,edebiyat">
    <meta name="author" content="Rabia ÖZCAN, Yahya Furkan KILIÇOĞLU,Muhammed Abdurrahman ÖTÜN, Hüseyin MUTLU">
    <!--CSS bağımlılıkları-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" >
    <!--Javascript Bağımlılıkları-->
    <script> <%@ include file = "static/js/fontawesome-icons.js" %></script>
    <title>YaziKolik</title>
    <style type="text/css">
    <%@ include file = "static/css/style.css" %>
    </style>
</head>
<body>
   
    <div class="container border p-3 my-3 text-center  w-50" id="loginform">
        <form action="login" method="post" >
            <div class="mb-3 bg-secondary py-2 rounded-3" style="color: white;">
                <h1>Üye Girişi</h1>
               
            </div>
            <div class="mb-3">
                <hr>
                <label for="email" class="form-label">E-Mail</label>
                <input type="email" class="form-control" id="email" name="email" required>
              </div>
              <div class="mb-3">
                <label for="sifre" class="form-label">Şifre</label>
                <input type="password" class="form-control" id="sifre" name="password" required>
              </div>
              <div class="mb-3">
                <button type="submit" class="btn btn-outline-success w-100">Giriş Yap</button>
              </div>
              <div class="mb-3">
                <a href="" style="text-decoration: none;color:teal" class="float-start mt-2"><small>Hemen Kayıt Ol</small></a>
                <div class="clearfix"></div>
              </div>
        </form>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>
    