function onlyDigits() {
    this.value = this.value.replace(/[^\d\.]/g, "");
    if(this.value.match(/\./g).length > 1) {
        this.value = this.value.substr(0, this.value.lastIndexOf("."));
    }
}
document.querySelector(".onlyDigits").onkeyup = onlyDigits