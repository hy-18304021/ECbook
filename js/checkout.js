function valueinName($this) {
    console.log($this.value);
    document.getElementById("bname").value = $this.value;
}
function valueinEmail($this) {
    console.log($this.value);
    document.getElementById("bemail").value = $this.value;
}
function valueinPostalcode($this) {
    console.log($this.value);
    document.getElementById("bpostalcode").value = $this.value;
}
function valueinAddress($this) {
    console.log($this.value);
    document.getElementById("badr").value = $this.value;
}
function valueinTel($this) {
    console.log($this.value);
    document.getElementById("btel").value = $this.value;
}
function valueinCardname($this) {
    console.log($this.value);
    document.getElementById("bcname").value = $this.value;
}
function valueinCardNumber($this) {
    console.log($this.value);
    document.getElementById("bccnum").value = $this.value;
}
function valueinExpmonth($this) {
    console.log($this.value);
    document.getElementById("bexpmonth").value = $this.value;
}
function valueinExpyrar($this) {
    console.log($this.value);
    document.getElementById("bexpyear").value = $this.value;
}
function valueinCvv($this) {
    console.log($this.value);
    document.getElementById("bcvv").value = $this.value;
}
function registeddata(starts){
    console.log(starts);
    console.log(document.getElementsByClassName("postalcode")[starts].value);
    document.getElementById("bpostalcode").value=document.getElementsByClassName("postalcode")[starts].value;
    document.getElementById("badr").value=document.getElementsByClassName("adr")[starts].value;
    document.getElementById("btel").value=document.getElementsByClassName("tel")[starts].value;
}