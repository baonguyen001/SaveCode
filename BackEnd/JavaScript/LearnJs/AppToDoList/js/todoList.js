class ToDoList{
    constructor(){
        this.ToDoList = [];
    }
    addToDo(todo){
        this.ToDoList.push(todo);
    }
    renderTodo(){
        let content = "";
        // tdContent biến chứa dữ liệu trả về sau khi duyệt mảng
        // item là 1 todo trong ds mảng
        // duyệt mảng từ phải qua trái
        content = this.ToDoList.reduceRight((tdContent, item, index)=>{
            tdContent += `
            <li>
                <span>${item.text}</span>
                <div class="buttons">
                    <button class="remove" data-index="${index}">
                        <i class="fa fa-trash-alt"></i>
                    </button>

                    <button class="completed" data-status="${item.status}" onclick="completedTodo(event)">
                        <i class="far fa-check-circle"></i>
                        <i class="fas fa-check-circle"></i>
                    </button>
                </div>
            </li>
        `;
        return tdContent;
        }, '')
        return content;
        
    }
    removeToDo(index){
        this.ToDoList.splice(index, 1);
    }
}