function page(start,count) {
    v1 = Number(start);
    v2 = Number(count);
    v3 = (v1/v2)+1;
    document.formBody.gotoPage.value = v3;
    document.formBody.start.value = start;
    document.formBody.count.value = count;
//    document.formBody.btSearch.click();
}


function countValue(amount,price){
    return document.formBody.mustbuy=amount*price;
}

function gotoPager() {
    if (document.formBody.gotoPage.value >= 1) {
        if (document.formBody.count.value == '' || document.formBody.count.value == 0) document.formBody.count.value = 10;
        var a = (document.formBody.gotoPage.value - 1) * document.formBody.count.value;
        document.formBody.start.value = a;
        document.formBody.gotoPage2.value = document.formBody.gotoPage.value;
        document.formBody.submit();
    }
}

function gotoPager2() {
    if (document.formBody.gotoPage2.value >= 1) {
        if (document.formBody.count.value == '' || document.formBody.count.value == 0) document.formBody.count.value = 10;
        var a = (document.formBody.gotoPage2.value - 1) * document.formBody.count.value;
        document.formBody.start.value = a;
        document.formBody.gotoPage.value = document.formBody.gotoPage2.value;
        document.formBody.submit();
    }
}

function sort(orderBy) {
    document.formBody.orderBy.value = orderBy;
    if (document.formBody.ascDesc.value=='') {
        document.formBody.ascDesc.value='desc';
    } else if (document.formBody.ascDesc.value=='desc') {
        document.formBody.ascDesc.value='asc';
    } else {
        document.formBody.ascDesc.value='desc';
    }
    document.formBody.submit();
}

function sortForTrxReport(orderBy, id) {
    document.formBody.orderBy.value = orderBy;
    document.formBody.orderId.value = id;
    if (document.formBody.ascDesc.value=='') {
        document.formBody.ascDesc.value='desc';
    } else if (document.formBody.ascDesc.value=='desc') {
        document.formBody.ascDesc.value='asc';
    } else {
        document.formBody.ascDesc.value='desc';
    }
    document.formBody.submit();
}

function getBatch(id) {
    if(document.getElementById(id).value != '0'){
        document.formBody.actionTools.value = 'updatebatch';
        document.formBody.appendChild(document.createElement("button")).click();
    }
}

function getMerchantBrand(id) {
    if(document.getElementById(id).value != '0'){
        document.formBody.actionTools.value = 'updatemb';
        document.formBody.appendChild(document.createElement("button")).click();
    }
}

function processVoid(invoiceNo) {
    var invNo = document.getElementById(invoiceNo).value;
    if (invNo!=""){
        var temp = confirm("Are you sure to process void for invoice no : "+invNo+" ?");
        if (temp) {
            return true;
        }
    } else {
        alert("Please input invoice no & retrieve details first..!");
    }
    return false;
}

function processSettle(batchNo) {
    var temp = confirm("Are you sure to settle manual batch no : "+batchNo+" ?");
    if (temp) {
        return true;
    }
    return false;
}