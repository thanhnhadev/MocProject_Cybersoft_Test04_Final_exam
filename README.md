# Final\_Example

file:
# https://github.com/allure-framework/allure2/releases

# ALLURE_HOME:file

# path:%ALLURE_HOME%\bin

for window:
# https://allurereport.org/docs/install-for-windows/
For mac os
https://allurereport.org/docs/install-for-macos/
video tutorial with window
https://anhtester.com/lesson/selenium-java-bai-34-cai-dat-va-su-dung-allure-report
reading document and flowing
when setup finish
we open termnial in source with 


\# allure serve target/allure-results and run



\*\*\* Lệnh này thì mặc định xuất ra folder allure-report:



allure generate --single-file target/allure-results

Java



\*\*\* Lệnh này ghi đè lên folder allure-report đang tồn tại (thêm --clean):



allure generate --single-file target/allure-results --clean

Java



\*\*\* Lệnh này xuất ra folder chỉ định cụ thể:

Ví dụ folder allure-report-2



allure generate --single-file target/allure-results -o allure-report-2

