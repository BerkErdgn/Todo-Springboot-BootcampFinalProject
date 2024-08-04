import React, { useState } from "react";
import "../index.css"; 
import { Button, Form, InputGroup, ListGroup, Card } from 'react-bootstrap';
import { Journals, Pencil, Trash } from 'react-bootstrap-icons';

function TodoMain() {

    const [task, setTask] = useState('');
    const [todoList, setTodoList] = useState([
        {
            id: 1,
            text: "React ile todolist uygulaması",
            completed: false,
        },
        {
            id: new Date().getTime(),
            text: "uuid kullanımı",
            completed: true,
        },
    ]);

    const addTodo = () => {
        if (task.trim() !== "") {
            setTodoList([
                ...todoList,
                {
                    id: new Date().getTime(),
                    text: task,
                    completed: false,
                }
            ]);
            setTask('');
        }
    };

    const deleteTodo = (id) => {
        setTodoList(todoList.filter(todo => todo.id !== id));
    };

    const toggleTodo = (id) => {
        setTodoList(todoList.map(todo =>
            todo.id === id ? { ...todo, completed: !todo.completed } : todo
        ));
    };

    const editTodo = (id) => {
        console.log(`Edit todo with id: ${id}`);
    };

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
                >
                    All
                </Button>
                <Button 
                    className="flex-fill mx-2" 
                    style={{ backgroundColor: '#24a2b8', borderColor: 'transparent', maxWidth: '150px' }}
                >
                    Done
                </Button>
                <Button 
                    className="flex-fill mx-2" 
                    style={{ backgroundColor: '#24a2b8', borderColor: 'transparent', maxWidth: '150px' }}
                >
                    Todo
                </Button>
            </div>
            <div className="col col-12 col-md-8 d-flex mx-auto mb-3">
                <ListGroup className="w-100">
                    {todoList.map((todo) => (
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
                                    value={todo.text}
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
                                    onClick={() => deleteTodo(todo.id)}
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
                        >
                            Delete done tasks
                        </Button>
                    </div>
                    <div className="col-6 d-flex justify-content-start">
                        <Button 
                            className="flex-fill mx-1" 
                            style={{ backgroundColor: 'red', borderColor: 'transparent' }}
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
