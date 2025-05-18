
function checkUsername(){
    //定义正则表达式表示字符串规则
    var username = /^[a-zA-Z0-9]{5,10}$/
    //获得用户在页面上输入的信息：
    var name = document.getElementById("username").value
    var userMase = document.getElementById("userMase")
    
    console.log("name:"+name)
    console.log(username.test(name))
    //格式有误时
    if(!username.test(name)){
        userMase.innerText="用户名格式有误"
        return false
    }
    //格式ok时
    userMase.innerText="OK"
    return true
}
function checkUserPassword(){
    //定义正则表达式表示字符串规则
    var password_text = /^[0-9]{6}$/
    //获得用户在页面上输入的信息：
    var password = document.getElementById("password").value
    var passwordName = document.getElementById("passwordName")

    console.log("name:"+passwordName)
    console.log(password_text.test(password))
    //格式有误时
    if(!password_text.test(password)){
        passwordName.innerText="密码格式有误"
        return false
    }
    //格式ok时
    passwordName.innerText="OK"
    return true
}
function fromData(){
    var flag1 = checkUserPassword()
    var flag2 = checkUsername()
    return flag1&&flag2
}