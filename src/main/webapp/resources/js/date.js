function date() {
    let today = new Date();
    let dd = today.getDate();
    let mm = today.getMonth() + 1; // Месяца идут с 0, так что добавляем 1.
    let yyyy = today.getFullYear();
    if(dd < 10){
        dd='0' + dd
    }
    if(mm < 10){
        mm='0' + mm
    }

    today = dd + '/' +  mm + '/'+ yyyy ;
    document.getElementById("datetime-local").setAttribute("value",  today);

}
date();