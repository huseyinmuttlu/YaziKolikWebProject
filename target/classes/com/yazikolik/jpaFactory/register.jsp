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
      <!--
        Ad 
        Soyad
        E-mail
        Tel-No
        Şifre
        İl-İlçe
        Adres
    -->

    <div class="container border p-3 my-3" id="registerform">
    <form method="post" action="" >
        <div class="mb-3 btn btn-primary w-100" style="cursor:auto">
            YazıKolik Üyelik Formu
        </div>
        <div class="mb-3">
            <label for="isim" class="form-label">Ad</label>
            <input type="text" class="form-control" id="isim" name="firstName" required>
          </div>
          <div class="mb-3">
            <label for="soyisim" class="form-label">Soyad</label>
            <input type="text" class="form-control" id="soyisim" name="lastName" required>
          </div>
        <div class="mb-3">
          <label for="emailadres" class="form-label">E-Mail Adresi</label>
          <input type="email" class="form-control" id="emailadres" name="email" aria-describedby="emailHelp" required>
        </div>
        <div class="mb-3">
            <label for="telno" class="form-label">Cep Telefonu</label>
            <input type="text" class="form-control" id="telno" name="phoneNumber" required>
        </div>
    
        <div class="mb-3">
            <label class="form-label" for="adres">Adres</label>
            <textarea class="form-control" id="adres" name="adress" required></textarea>
          </div>
        <div class="mb-3">
          <label for="sifre" class="form-label">Şifre</label>
          <input type="password" class="form-control" id="sifre" name="password">
        </div>
        <div class="mb-3">
          <a href="" class="float-end pt-1" style="text-decoration: none;">Zaten Üye Misin?</a>
        </div>
        <button type="submit" class="btn btn-success w-25">Kayıt Ol</button>
      </form>
    </div>
    
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>
    
    