$(document).ready(function () {

    var callData = new CallData();
    var listChose = new ListChose();

    renderHTML();


    function renderHTML() {
        callData.getDataList()
            .done(function (result) {
                var contentNavPills = "";
                var contentTabPane = "";
                result.navPills.forEach(function (item, index) {
                    var classAtive = item.tabName === "tabTopClothes" ? "active" : "";
                    var fadeClass = item.tabName !== "tabTopClothes" ? "fade" : "";
                    contentNavPills += getElmTabPill(item, classAtive);
                    contentTabPane += `
                        <div class="tab-pane container ${classAtive} ${fadeClass}" id="${item.tabName}">
                            <div class="row">
                               ${renderTabPane(item.tabName, result.tabPanes)}
                            </div>
                        </div>
                    `
                });
                $(".nav-pills").html(contentNavPills);
                $(".tab-content").html(contentTabPane);
            })
            .fail(function (err) {
                console.log(err)
            });
    }

    function getElmTabPill(item, classAtive) {
        return `
        <li class="nav-item">
            <a class="nav-link ${classAtive} btn-default"
                data-toggle="pill"
                href="#${item.tabName}"
            >${item.showName}</a>
        </li>
        `
    }

    function getTypeArr(tabType, data) {
        var tempArr = [];
        data.forEach(function (item) {
            if (item.type === tabType) {
                tempArr.push(item);
            }
        });
        return tempArr;
    }

    function getElmItem(tempArr) {
        var elmItem = "";
        tempArr.forEach(function (item) {
            elmItem += `
            <div class="col-md-3">
                <div class="card text-center">
                    <img
                    src="${item.imgSrc_jpg}"
                    />
                    <h4><b>${item.name}</b></h4>
                    <button data-id="${item.id}" data-type="${item.type}" data-name="${item.name}" data-desc="${item.desc}" data-imgSrcjpg="${item.imgSrc_jpg}" data-imgSrcpng="${item.imgSrc_png}" class="changeStyle">Thử đồ</button>
                </div>
            </div>
            `
        });
        return elmItem;
    }

    function renderTabPane(tabName, arrTabPanes) {
        var tempArr = null;
        var elmItem = null;
        switch (tabName) {
            case "tabTopClothes":
                tempArr = getTypeArr("topclothes", arrTabPanes);
                var elmItem = getElmItem(tempArr);
                break;
            case "tabBotClothes":
                tempArr = getTypeArr("botclothes", arrTabPanes);
                var elmItem = getElmItem(tempArr);
                break;
            case "tabShoes":
                tempArr = getTypeArr("shoes", arrTabPanes);
                var elmItem = getElmItem(tempArr);
                break;
            case "tabHandBags":
                tempArr = getTypeArr("handbags", arrTabPanes);
                var elmItem = getElmItem(tempArr);
                break;
            case "tabNecklaces":
                tempArr = getTypeArr("necklaces", arrTabPanes);
                var elmItem = getElmItem(tempArr);
                break;
            case "tabHairStyle":
                tempArr = getTypeArr("hairstyle", arrTabPanes);
                var elmItem = getElmItem(tempArr);
                break;
            case "tabBackground":
                tempArr = getTypeArr("background", arrTabPanes);
                var elmItem = getElmItem(tempArr);
                break;
        }

        return elmItem;
    }

    function findIndex(type) {

        var index = -1;
        if (listChose.arr && listChose.arr.length > 0) {
            listChose.arr.forEach(function (item, i) {
                if (item.type === type){
                    index = i;
                }
            });
        }
        return index;
    }

    function renderClother(listChose){
        var clother = "";
        listChose.forEach(function(item){
            clother+=`
                <img src="${item.imgSrc_png}" alt="">
            `
        })
    }

    // button duoc render ra sau => khong the tuong tac
    // Uy quyen cho "body" = delegate => tuong tac duoc
    $("body").delegate(".changeStyle", "click", function () {
        var id = $(this).data("id");
        var type = $(this).data("type");
        var name = $(this).data("name");
        var desc = $(this).data("desc");
        var imgsrc_jpg = $(this).data("imgsrcjpg");
        var imgsrc_png = $(this).data("imgsrcpng");

        var choseItem = new ChooseItem(id, type, name, desc, imgsrc_jpg, imgsrc_png);
        var index = findIndex(choseItem.type);
        if(index !== -1){
            // Update
            listChose.arr[index] = choseItem;
        }else{
            // Add
            listChose.addItem(choseItem);
        }



        console.log(listChose.arr);
    })

})