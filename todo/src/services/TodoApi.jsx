// http://localhost:4444/todo/api/v1/delete/all
// proxy:    http://localhost:4444/
import axios from "axios";

const TODO_API_PERSIST_URL = "todo/api/v1"


class TodoApi{

 // SPEED DATA
 // http://localhost:4444/todo/api/v1/speed/5
    todoApiSpeedData(data){
        return axios.get(TODO_API_PERSIST_URL+"/speed/10");
    }


 // DELETE ALL
 // http://localhost:4444/todo/api/v1/delete/all
    todoApiDeleteAllData(){
        return axios.delete(`${TODO_API_PERSIST_URL}/delete/all`);
    }

// DELETE COMPLETED
// http://localhost:4444/todo/api/v1/delete/completed
    todoApiDeleteCompletedData() {
        return axios.delete(`${TODO_API_PERSIST_URL}/delete/completed`);
    }


 // CRUD
 // CREATE
 // http://localhost:4444/todo/api/v1/create
    todoApiCreate(todoDto){
        return axios.post(`${TODO_API_PERSIST_URL}/create`,todoDto);
    }



 // LIST
 // http://localhost:4444/todo/api/v1/list

    todoApiList(){
        return axios.get(`${TODO_API_PERSIST_URL}/list`);
    }



 // FIND
 // http://localhost:4444/todo/api/v1/find/1
    todoApiFindById(id){
        return axios.get(`${TODO_API_PERSIST_URL}/find/${id}`);
    }



 // UPDATE
 // http://localhost:4444/todo/api/v1/update/1
    todoApiUpdate(id, todoDto) {
        return axios.put(`${TODO_API_PERSIST_URL}/update/${id}`, todoDto);
    }



 // DELETE
 // http://localhost:4444/todo/api/v1/delete
    todoApiDeleteById(id){
        return axios.delete(`${TODO_API_PERSIST_URL}/delete/${id}`);
    }

}

export default new TodoApi();

