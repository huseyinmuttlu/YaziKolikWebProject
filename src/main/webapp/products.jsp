<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList,com.yazikolik.model.Product"%>



<div class="container my-2">
        <div class="row row-cols-2 row-cols-md-3 row-cols-lg-4">
           <c:forEach items="${productList}" var="product">
            <!--ürün başlangıcı-->
			<div class="col">
            <div class="card text-center mb-4 shadow-items py-2">
                <div class="pb-3">
                    <img src="${product.getImageUrl()}" alt="">
                </div>
                <div class="border-top border-bottom pt-1 mb-2">
                    <p class="product-attr">${product.getTitle()}</p>
                    <p class="product-attr">${product.getAuthor()}</p>
                    <p class="product-attr">${product.getPublisher() }</p>
                    <p class="product-attr">${product.getPrice()}</p>
                </div>
                <div>
                    <button class="me-3 btn btn-outline-success cartAdd" type="submit"><i class="fas fa-shopping-cart pe-2"></i>Ekle</button>
                    <button class="btn rounded-pill btn-sm btn-outline-danger btn-decrease" type="button"><i class="fas fa-minus"></i></button>
                    <input type="number" value="1" style="width:25px;border:none;padding-left:6px;" class="mx-1">
                    <button class="btn rounded-pill btn-sm btn-outline-success btn-increase" type="button"><i class="fas fa-plus"></i></button>
                </div>
            </div>
        </div>
        <!--ürün bitişi-->
     </c:forEach>
        </div>
    </div>

    <!--Toast Start-->
    <div class="fixed-top top-0 end-0">
    <div class="toast position-absolute top-0 end-0 align-items-center text-white bg-success" role="alert" aria-live="assertive" aria-atomic="true"  data-bs-delay="1500">
        <div class="toast-header">
            <i class="fas fa-check pe-3"></i>
          <strong class="me-auto">Urun sepete eklendi</strong>
          <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
      </div>
    </div>
 <!--Toast Finish-->