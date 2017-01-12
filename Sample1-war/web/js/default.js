function resetPaging() {
    document.formBody.start.value = 0;
}

function page(start,count) {
    loading('Processing',1);
    document.formBody.gotoPage.value = '';
    document.formBody.start.value = start;
    document.formBody.count.value = count;
    try{
        document.formBody.submit();
    } catch(err){
        document.getElementById("formBody").submit();
    }
    
}

function gotoPager() {
    if (document.formBody.gotoPage.value >= 1) {
        if (document.formBody.count.value == '' || document.formBody.count.value == 0) document.formBody.count.value = 10;
        loading('Processing',1);
        var a = (document.formBody.gotoPage.value - 1) * document.formBody.count.value;
        document.formBody.start.value = a;
        document.formBody.gotoPage2.value = document.formBody.gotoPage.value;
        document.formBody.submit();
    }
}

function gotoPager2() {
    if (document.formBody.gotoPage2.value >= 1) {
        if (document.formBody.count.value == '' || document.formBody.count.value == 0) document.formBody.count.value = 10;
        loading('Processing',1);
        var a = (document.formBody.gotoPage2.value - 1) * document.formBody.count.value;
        document.formBody.start.value = a;
        document.formBody.gotoPage.value = document.formBody.gotoPage2.value;
        document.formBody.submit();
    }
}

function sort(orderBy) {
    loading('Processing',1);
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
    loading('Processing',1);
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

function isNumber(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}

function loading(name, overlay) {
    $('#content-preloader').html(name+'...');
    if(overlay==1){
        $('#overlay').css('opacity',0.3).fadeIn(function(){
            $('#preloader').fadeIn();
        });
    } else {
        $('#overlay').css('opacity',0.3).fadeIn(function(){
            $('#preloader').fadeIn();
        });
    }
}

function loadingConfirm(name, overlay) {
    var r=confirm("Are you sure to " + name + " ?");
    if (r==true) {
        $('#content-preloader').html(name+', please wait...');
        if(overlay==1){
            $('#overlay').css('opacity',0.3).fadeIn(function(){
                $('#preloader').fadeIn();
            });
        } else {
            $('#overlay').css('opacity',0.3).fadeIn(function(){
                $('#preloader').fadeIn();
            });
        }
        return true;
    } else {
        return false;
    }
}

function unloading() {
    $('#preloader').fadeOut('fast',function(){
        $('#overlay').fadeOut();
    });
}


