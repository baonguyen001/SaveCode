class GlassesList {
    constructor() {
        this.glist = []
    }
    addGlasess(glasses) {
        this.glist.push(glasses)
    }
    renderGlasses() {
        // // Cac the HTML chua noi dung doi tuong kinh
        let content = ""
          content = this.glist.reduce((glContent, item, index) => {
             glContent += `
                 <div class = "col-4">
                     <img class = "img-fluid vglasses__items" onclick="tryOnGlasses(event)" data-id = "${item.id}" src = "${item.src}" alt = "glasses">
                 </div>
             `
             return glContent
         }, '')

         return content
     
    }
}