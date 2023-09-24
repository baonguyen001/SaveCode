function xepLoai(diemTb){
    if(diemTb >= 9){
        console.log("Xuat sac");
    }else if(diemTb >= 8){
        console.log("Gioi");
    }else if(diemTb >= 7){
        console.log("Kha");
    }else if(diemTb >= 6){
    console.log("Tb Kha");
    }else if(diemTb >= 5){
        console.log("TB");
    }else {
        console.log("Yeu")
    }
}

function tinhDiemTb(toan, ly, hoa){
    var diemTb = (toan + ly + hoa) / 3;
    return diemTb;
}

function click(){
    var diemTb = tinhDiemTb(9, 8, 7.5);
    console.log(diemTb);
    xepLoai(diemTb);
}

click();