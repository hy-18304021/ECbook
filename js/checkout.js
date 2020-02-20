function valueinName($this) {
    document.getElementById("bname").value = $this.value;
}
function valueinPostalcode($this) {
    document.getElementById("bpostalcode").value = $this.value;
}
function valueinAddress($this) {
    document.getElementById("badr").value = $this.value;
}
function valueinTel($this) {
    document.getElementById("btel").value = $this.value;
}
function valueinCardname($this) {
    document.getElementById("bcname").value = $this.value;
}
function valueinCardNumber($this) {
    document.getElementById("bccnum").value = $this.value;
}
function valueinExpmonth($this) {
    document.getElementById("bexpmonth").value = $this.value;
}
function valueinExpyrar($this) {
    document.getElementById("bexpyear").value = $this.value;
}
function valueinCvv($this) {
    document.getElementById("bcvv").value = $this.value;
}
function registeddata(starts){
    console.log(starts);
    console.log(document.getElementsByClassName("postalcode")[starts].value);
    document.getElementById("bbtn").value=document.getElementsByClassName("btn")[starts].value;   
    document.getElementById("baddress_id").value=document.getElementsByClassName("address_id")[starts].value;   
    document.getElementById("bname").value = document.getElementsByClassName("receiver_name")[starts].value;
    document.getElementById("bpostalcode").value=document.getElementsByClassName("postalcode")[starts].value;
    document.getElementById("badr").value=document.getElementsByClassName("adr")[starts].value;
    document.getElementById("btel").value=document.getElementsByClassName("tel")[starts].value;
}