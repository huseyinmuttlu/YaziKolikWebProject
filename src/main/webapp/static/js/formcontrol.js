$("#credit-card,#cvv").keypress(function (e) {
    if ((e.which < 48 || e.which > 57) && (e.which !== 8) && (e.which !== 0)) {
       return false;
    }
    if (this.value.length === 4 || this.value.length === 9 || this.value.length === 14) {
     this.value = this.value += ' ';
    }
    return true;
    });
    
    
    $("#tarih").keypress(function (e) {
    if(this.selectionStart==0 && e.which > 49 ){
       return false;
    }
    if ((e.which < 48 || e.which > 57) && (e.which !== 8) && (e.which !== 0)) {
       return false;
    }
    if (this.value.length === 2) {
     this.value = this.value += '/';
    }
    return true;
    });