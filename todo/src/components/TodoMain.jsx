import React, { useEffect, useState } from "react";
import "../index.css"; 
import { Button, Form, InputGroup, ListGroup, Card } from 'react-bootstrap';
import { Journals, Pencil, Trash } from 'react-bootstrap-icons';
import TodoApi from "../services/TodoApi";

function TodoMain() {

    //UseState
    const [task, setTask] = useState('');
    const [todoList, setTodoList] = useState([]);
    const [filter, setFilter] = useState('all');

    //UseEffect
    useEffect(()=>{
        fetchTodoApiListData();
    },[]);

    //Bütün todoları getirmek için
    const fetchTodoApiListData = async ()=>{
        try {
            const response = await TodoApi.todoApiList();
            setTodoList(response.data);
        } catch (error) {
            console.error("Error fetching todo list:", error);
        }
    };

    //Todo eklemek için
    const addTodo = () =>{
        if (task.trim() !=="") {
            const newTodo = {
                title: task,
                completed: false,
            };
            TodoApi.todoApiCreate(newTodo).then(response =>{
                setTodoList([...todoList, response.data]);
                setTask("");
            }).catch(error =>{
                console.error("Error adding todo:", error);
            });
        }
    };
    
    //Todo silmek için
    const deleteTodo = (id,title) => {
        if (window.confirm(title + " => todo'yu Silmek istiyor musunuz ?")) {
            TodoApi.todoApiDeleteById(id).then(()=>{
                setTodoList(todoList.filter(todo=> todo.id !==id));
            }).catch(error=>{
                console.error("Error deleting todo:", error);
            });
        }else{
            window.alert("Silme işlemi iptal edildi.");
        }
    };

    //Todoyu tamamlandı yapmak yada tamamlanmadı yapmak için
    const toggleTodo = (id) => {
        const todoToToggle = todoList.find(todo => todo.id === id);
        if (todoToToggle) {
            const updatedTodo = { 
                id: todoToToggle.id, 
                title: todoToToggle.title, 
                completed: !todoToToggle.completed 
            };
            console.log("Sending update:", updatedTodo);
            TodoApi.todoApiUpdate(id, updatedTodo).then(response => {
                console.log("Server response:", response);
                setTodoList(todoList.map(todo => todo.id === id ? updatedTodo : todo));
            }).catch(error => {
                console.error("Error toggling todo:", error.response ? error.response.data : error.message);
            });
        }
    };


    const editTodo = (id) => {
        console.log(`${id} nolu task editlendi.`);
    };

    // Bütün toduları silmek için
    const deleteAllTodos = () => {
        if (window.confirm("Tüm todo'ları silmek istiyor musunuz?")) {
            TodoApi.todoApiDeleteAllData().then(() => {
                setTodoList([]);
            }).catch(error => {
                console.error("Error deleting all todos:", error);
            });
        } else {
            window.alert("Silme işlemi iptal edildi.");
        }
    };

    // Tamamlanmış toduları silmek için
    const deleteCompletedTodos = () => {
        if (window.confirm("Tamamlanmış tüm todo'ları silmek istiyor musunuz?")) {
            TodoApi.todoApiDeleteCompletedData().then(() => {
                setTodoList(todoList.filter(todo => !todo.completed));
            }).catch(error => {
                console.error("Error deleting completed todos:", error);
            });
        } else {
            window.alert("Silme işlemi iptal edildi.");
        }
    };

    const showAllTodos = () => setFilter('all');
    const showCompletedTodos = () => setFilter('completed');
    const showTodoTodos = () => setFilter('todo');

    const filteredTodoList = todoList.filter(todo => {
        if (filter === 'all') return true;
        if (filter === 'completed') return todo.completed;
        if (filter === 'todo') return !todo.completed;
        return true;
    });


    return (
        <div className="container">
            <div className="text-center mb-5">
                <h1 style={{ color: 'black', fontWeight: 'bold' }}>Todo App</h1>
            </div>
            <div className="col col-12 col-md-8 d-flex mx-auto mb-3">
                <Card className="p-3 w-100" style={{ borderColor: '#e0e0e0', borderWidth: '1px' }}>
                    <InputGroup>
                        <InputGroup.Text
                            style={{
                                backgroundColor: '#24a2b8', 
                                border: '1px solid #ddd',
                                borderRight: 'none',
                                display: 'flex',
                                alignItems: 'center',
                                justifyContent: 'center',
                                height: 'calc(2.25rem + 2px)' 
                            }}
                        >
                            <Journals size={20} color="white" />
                        </InputGroup.Text>
                        <Form.Control
                            placeholder="Enter new todo..."
                            aria-label="Recipient's username"
                            aria-describedby="basic-addon2"
                            value={task}
                            onChange={(e) => setTask(e.target.value)}
                            style={{ flex: 1, height: 'calc(2.25rem + 2px)' }} 
                        />
                    </InputGroup>
                    <Button
                        className="w-100 mt-2 text-white"
                        style={{
                            backgroundColor: '#24a2b8', 
                            borderColor: 'transparent'
                        }}
                        onClick={addTodo}
                    >
                        Add Todo
                    </Button>
                </Card>
            </div>
            <div className="text-center mb-4">
                <h2 style={{ color: 'grey', fontWeight: 'bold' }}>Todo List</h2>
            </div>
            <div className="d-flex justify-content-center mb-4">
                <Button 
                    className="flex-fill mx-2" 
                    style={{ backgroundColor: '#24a2b8', borderColor: 'transparent', maxWidth: '150px' }}
                    onClick={showAllTodos}
                >
                    All
                </Button>
                <Button 
                    className="flex-fill mx-2" 
                    style={{ backgroundColor: '#24a2b8', borderColor: 'transparent', maxWidth: '150px' }}
                    onClick={showCompletedTodos}
                >
                    Done
                </Button>
                <Button 
                    className="flex-fill mx-2" 
                    style={{ backgroundColor: '#24a2b8', borderColor: 'transparent', maxWidth: '150px' }}
                    onClick={showTodoTodos}
                >
                    Todo
                </Button>
            </div>
            <div className="col col-12 col-md-8 d-flex mx-auto mb-3">
                <ListGroup className="w-100">
                    {filteredTodoList.map((todo) => (
                        <ListGroup.Item
                            key={todo.id}
                            className="m-2 p-3 rounded-3 d-flex align-items-center"
                            style={{ backgroundColor: 'white', border: '1px solid #ddd' }}
                            onDoubleClick={() => toggleTodo(todo.id)}
                        >
                            <InputGroup className="me-2">
                                <Form.Check
                                    type="checkbox"
                                    checked={todo.completed}
                                    onChange={() => toggleTodo(todo.id)} 
                                    style={{ marginRight: '10px' }}
                                />
                                <Form.Control
                                    value={todo.title}
                                    readOnly
                                    className={
                                        todo.completed
                                            ? "text-decoration-line-through"
                                            : "text-decoration-none"
                                    }
                                    style={{ border: 'none' }}
                                />
                            </InputGroup>
                            <div className="d-flex align-items-center ms-auto">
                                <Pencil
                                    size={16}
                                    color="#F57C00"
                                    className="me-2"
                                    role="button"
                                    onClick={() => editTodo(todo.id)}
                                />
                                <Trash
                                    size={16}
                                    color="red"
                                    role="button"
                                    onClick={() => deleteTodo(todo.id,todo.title)}
                                />
                            </div>
                        </ListGroup.Item>
                    ))}
                </ListGroup>
            </div>
            <div className="col col-12 col-md-8 d-flex mx-auto">
                <div className="row w-100">
                    <div className="col-6 d-flex justify-content-end">
                        <Button 
                            className="flex-fill mx-1" 
                            style={{ backgroundColor: 'red', borderColor: 'transparent' }}
                            onClick={deleteCompletedTodos}
                        >
                            Delete done tasks
                        </Button>
                    </div>
                    <div className="col-6 d-flex justify-content-start">
                        <Button 
                            className="flex-fill mx-1" 
                            style={{ backgroundColor: 'red', borderColor: 'transparent' }}
                            onClick={deleteAllTodos}
                        >
                            Delete all tasks
                        </Button>
                    </div>
                </div>
            </div>
        </div>
    );//end return
}//end function TodoMain

export default TodoMain;
