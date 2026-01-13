import './App.css';
import TicketForm from './assets/Components/TicketForm.jsx';
import Table from './assets/Components/Table.jsx';

function App() {

  
  return (
    <div className="App">
      <h1>Tickets</h1>
      <br />
      <br />
      <TicketForm />  

      <br /><br />
      <Table />
    </div>
  );
}

export default App;
