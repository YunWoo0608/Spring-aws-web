<%@page import="com.homeshopping.myapp.shopping.model.customer.Customer_VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
    <script>
    $(function(){
        IMP.init('imp61085654'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'inicis',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : 'AI 테스트 결제',
            amount : ${totalPrice},
            buyer_email : '${cust_vo.c_email}',
            buyer_name :'${cust_vo.c_name}',
            buyer_tel : '${cust_vo.c_phone}',
            buyer_addr : '${cust_vo.c_add}',
            buyer_postcode : '123-456',
            //m_redirect_url : 'http://www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) {
                msg = '결제가 완료되었습니다.';
                msg += '\n고유ID : ' + rsp.imp_uid;
                msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                msg += '\결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;
                c_no = ${cust_vo.c_no};
                pr_no = ${pr_vo.pr_no};
                alert(msg);
                //성공시 이동할 페이지
                location.href='<%=request.getContextPath()%>/pay_success?imp_uid='+rsp.imp_uid+'&merchant_uid='+rsp.merchant_uid+'&paid_amount='+rsp.paid_amount+'&apply_num='+rsp.apply_num+'&c_no='+c_no+'&pr_no='+pr_no+'&totalPrice='+${totalPrice};
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="<%=request.getContextPath()%>/";
                alert(msg);
            }
        });
        
    });
    </script>
 
</body>
</html>
