
let todoList = new ToDoList();
let completedList = new ToDoList();

// Ham rut gon 
const getEle = id => {
    return document.getElementById(id);
}

// Thêm todo
const addToDo = () => {
    let txtTodo = getEle("newTask").value;
    let ulToDo = getEle("todo");

    if (txtTodo != "") {
        let td = new ToDo(txtTodo, "todo");
        todoList.addToDo(td);
    }
    showToDoList(ulToDo);
    // txtTodo.innerHTML = "";
}

// Hàm hiện thị todo
const showToDoList = (ulToDo) => {
    ulToDo.innerHTML = todoList.renderTodo();
}

// Hàm delete todo
// const deleteToDo = (e)=>{
//     let indexTodo = e.target.getAttribute("data-index");
//     let ulToDo = getEle("todo");
//     todoList.removeToDo(indexTodo);
//     showToDoList(ulToDo);
// }


const completedTodo = (e) => {
    let indexTodo = e.target.getAttribute("data-index");
    let status = e.target.getAttribute("data-status");

    if(status == "todo"){

    }


}


getEle("addItem").addEventListener("click", () => {
    addToDo();
})


