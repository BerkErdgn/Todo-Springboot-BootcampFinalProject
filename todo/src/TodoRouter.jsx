//rfce
import React from 'react'
import TodoHeader from './components/TodoHeader'
import TodoMain from './components/TodoMain'
import TodoFooter from './components/TodoFooter'
import { withTranslation } from "react-i18next";
import './App.css'; 

//Function Component
function TodoRouter() {
  return (
      <React.Fragment>
        <div className="app-container">
          <TodoHeader />
          <div className="content">
            <TodoMain />
          </div>
          <TodoFooter />
        </div>
      </React.Fragment>
  )// end return
}// end TodoRouter

//Export
export default withTranslation()(TodoRouter);