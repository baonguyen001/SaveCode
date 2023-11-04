let dataGlasses = [
    { id: "G1", src: "./img/g1.jpg", virtualImg: "./img/v1.png", brand: "Armani Exchange", name: "Bamboo wood", color: "Brown", price: 150, description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis ea voluptates officiis? " },
    { id: "G2", src: "./img/g2.jpg", virtualImg: "./img/v2.png", brand: "Arnette", name: "American flag", color: "American flag", price: 150, description: "Lorem ipsum dolor, sit amet consectetur adipisicing elit. In assumenda earum eaque doloremque, tempore distinctio." },
    { id: "G3", src: "./img/g3.jpg", virtualImg: "./img/v3.png", brand: "Burberry", name: "Belt of Hippolyte", color: "Blue", price: 100, description: "Lorem ipsum dolor, sit amet consectetur adipisicing elit." },
    { id: "G4", src: "./img/g4.jpg", virtualImg: "./img/v4.png", brand: "Coarch", name: "Cretan Bull", color: "Red", price: 100, description: "In assumenda earum eaque doloremque, tempore distinctio." },
    { id: "G5", src: "./img/g5.jpg", virtualImg: "./img/v5.png", brand: "D&G", name: "JOYRIDE", color: "Gold", price: 180, description: "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Error odio minima sit labore optio officia?" },
    { id: "G6", src: "./img/g6.jpg", virtualImg: "./img/v6.png", brand: "Polo", name: "NATTY ICE", color: "Blue, White", price: 120, description: "Lorem ipsum dolor, sit amet consectetur adipisicing elit." },
    { id: "G7", src: "./img/g7.jpg", virtualImg: "./img/v7.png", brand: "Ralph", name: "TORTOISE", color: "Black, Yellow", price: 120, description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Enim sint nobis incidunt non voluptate quibusdam." },
    { id: "G8", src: "./img/g8.jpg", virtualImg: "./img/v8.png", brand: "Polo", name: "NATTY ICE", color: "Red, Black", price: 120, description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Reprehenderit, unde enim." },
    { id: "G9", src: "./img/g9.jpg", virtualImg: "./img/v9.png", brand: "Coarch", name: "MIDNIGHT VIXEN REMIX", color: "Blue, Black", price: 120, description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit consequatur soluta ad aut laborum amet." }
];


// Khoi tao 
let glassesList = new GlassesList()


// Ham lay id 
const getEle = (id) => {
    return document.getElementById(id)
}

// Hien thi ds kinh
const showGlassesList = () => {
    let divGlassesList = getEle("vglassesList")

    // Tao doi tuong kinh add vao ds kinh
    dataGlasses.map((item) => {
        let gl = new Glasses(item.id, item.src, item.virtualImg, item.brand, item.name, item.color, item.price, item.description)
        glassesList.addGlasess(gl)
    })
    // console.log(glassesList.glist)
    divGlassesList.innerHTML = glassesList.renderGlasses()

}

showGlassesList();

const tryOnGlasses = (e) => {
    let gID = e.target.getAttribute("data-id");
    let gObject = {};
    for (let value of glassesList.glist) {
        if (value.id == gID) {
            gObject = value;
        }
    }
    // console.log(gObject);
    showInfo(gObject);

}

const showInfo = (gObject) => {
    let divAvatar = getEle("avatar");
    let divInfo = getEle("glassesInfo");
    divAvatar.innerHTML = `
    <img id="glasses" src="${gObject.virtualImg}">
    `;

    let status = "";
    if(gObject.status){
        status = "Stocking";
    }else{
        status = "Solt Out";
    }

    divInfo.innerHTML = `
    <h5>${gObject.name} - ${gObject.brand} (${gObject.color})</h5>
    <p class="card-text">
        <span class="btn btn-danger btn-sm mr-2">$${gObject.price}</span>
        <span class="text-success">${status}</span>
    </p>
    <p class="card-text">
        ${gObject.description}xxxx
    </p>
    `;
    divInfo.style.display = "block";
}

const removeClass = (isDisplay)=>{
    let glasses = getEle("glasses");
    if(isDisplay){
        glasses.style.display = "block";
    }else{
        glasses.style.display = "none";

    }
}

