function checkUsername(){
    //定义正则表达式规则：
    var name_test = /^[a-zA-Z0-9]{6,10}$/
    //取值
    var name = document.getElementById("name").value
    var name_sp = document.getElementById("name_sp")
    if (!name_test.test(name)) {
        name_sp.innerText = "格式有误，请输入6到10位的字符数字"
        return false
    }
    name_sp.innerText="ok"
    return true
}
function checkPassword1(){
    //定义正则表达式规则：
    var password_text = /^[0-9]{6}$/
    //取值
    var password = document.getElementById("password").value
    var password_sp = document.getElementById("password_sp")
    if (!password_text.test(password)) {
        password_sp.innerText = "格式有误，请输入6到10位的字符数字"
        return false
    }
    password_sp.innerText="ok"
    return true
}
function checkPassword2(){
    //定义正则表达式规则：
    var password_text = /^[0-9]{6}$/
    //取值
    var password = document.getElementById("password").value
    var password1 = document.getElementById("password_1").value
    var password_sp2 = document.getElementById("password_sp2")
    if (!password_text.test(password1)) {
        password_sp2.innerText = "格式有误，请输入6到10位的字符数字"
        return false
    }
    if(password!=password1){
        password_sp2.innerText = "两次输入密码不符合，请重新输入"
        return false
    }
    password_sp2.innerText="ok"
    return true
}
function regi(){
    var flag1 = checkUsername()
    var flag2 = checkPassword1()
    var flag3 = checkPassword2()
    return flag1&&flag2&&flag3
}