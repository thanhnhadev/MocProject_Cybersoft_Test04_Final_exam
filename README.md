
# Final_Example
Mình đặt tên biến môi trường là ALLURE_HOME


Tải gói Allure-2.27.0 cho Window tại https://github.com/allure-framework/allure2/releases (cứ tải bản mới nhất nhé)

 trên môi trường máy window 

Link download theo phiên bản: https://github.com/allure-framework/allure2/releases


Tiếp theo thì các bạn giải nén ra để nó vào ổ C (ổ chứa hệ điều hành) để tạo biến môi trường trong máy ổn định.

Tạo biến môi trường giống với setup biến môi trường Java JDK á

ALLURE_HOME C:\Program Files\allure-2.34.1

Edit biến 
path %ALLURE_HOME%\bin 


mở ide code 

Tiếp theo là chạy lệnh trong Terminal:  allure serve allure-results
