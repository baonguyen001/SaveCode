$(document).ready(function () {
 
    var linkRestaurant = "http://localhost:8083/restaurant"
    var token = localStorage.getItem("token")
    console.log(token)

    $.ajax({
        method: "GET",
        url: linkRestaurant,
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
    //msg đại diện cho giá trị backend trả ra
        .done(function (msg) {
            if(msg.success){
                $.each(msg.data, function(index, value){
                    console.log(value)
                    var html = `<a href="detail.html" class="text-dark text-decoration-none col-xl-4 col-lg-12 col-md-12">
                                <div class="bg-white shadow-sm rounded d-flex align-items-center p-1 mb-4 osahan-list">
                                    <div class="bg-light p-3 rounded">
                                        <img src="${linkRestaurant}/file/${value.image}" class="img-fluid">
                                    </div>
                                    <div class="mx-3 py-2 w-100">
                                        <p class="mb-2 text-black">${value.title}</p>
                                        <p class="small mb-2">
                                            <i class="mdi mdi-star text-warning mr-1"></i> <span
                                                class="font-weight-bold text-dark">${value.rating.toFixed(1)}</span> (873)
                                            <i class="mdi mdi-silverware-fork-knife ml-3 mr-1"></i> ${value.subtitle}
                                        </p>
                                        <p class="mb-0 text-muted d-flex align-items-center"><span
                                                class="badge badge-light"><i class="mdi mdi-truck-fast-outline"></i> Free
                                                delivery</span>
                                        </p>
                                    </div>
                                </div>
                            </a>`
    
                     $("#featured-restaurant").append(html)

                })
               
            }

          
            console.log(msg)  
        });
})

