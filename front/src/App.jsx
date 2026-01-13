import { useState } from 'react';
import './App.css';

function App() {

  const [count, setCount] = useState([]);
  const [tipo, setTipo] = useState('CONSULTA');
  const [prioridadManual, setPrioridadManual] = useState(1);
  const [usuario, setUsuario] = useState('Geff');

  const handleSubmit = (e) => {
    e.preventDefault();
    const solicitud = { tipo, prioridadManual, usuario };
    fetch('http://localhost:5000/api/v1/solicitudes', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(solicitud),
    })
      .then(response => response.json())
      .then(data => console.log('Solicitud creada:', data))
      .catch(error => console.error('Error creando solicitud:', error));
  };

  fetch('http://localhost:5000/api/v1/solicitudes/priorizadas')
    .then(response => response.json())
    .then(data => setCount(data))
    .catch(error => console.error('Error fetching tickets:', error));

  return (
    <div className="App">
      <h1>Tickets</h1>
      <br />
      <br />
      <div className='mainContainerForm'>
        <h2>Crear solicitud</h2>

        <form onSubmit={handleSubmit}>
          <label>
            Tipo:
            <select value={tipo} onChange={(e) => setTipo(e.target.value)}>
              <option value="INCIDENTE">INCIDENTE</option>
              <option value="REQUERIMIENTO">REQUERIMIENTO</option>
              <option value="CONSULTA">CONSULTA</option>
            </select>
          </label>
          <label>
            Prioridad Manual:
            <input type="number" max="5" min="1" value={prioridadManual} onChange={(e) => setPrioridadManual(e.target.value)} />
          </label>
          <label>
            Usuario:
            <input type="text" value={usuario} onChange={(e) => setUsuario(e.target.value)} />
          </label>
          <button type="submit">Crear Solicitud</button>
        </form>

      </div>

      <br /><br />

      <div className='mainContainerTable'>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Tipo</th>
              <th>Usuario</th>
              <th>Prioridad Manual</th>
              <th>Priorización Calculada</th>
              <th>Fecha Creación</th>
            </tr>
          </thead>
          <tbody>
            {count.map((ticket) => (
              <tr key={ticket.id}>
                <td>{ticket.id}</td>
                <td>{ticket.tipo}</td>
                <td>{ticket.usuario}</td>
                <td>{ticket.prioridadManual}</td>
                <td>{ticket.priorizacionCalculada}</td>
                <td>{new Date(ticket.fechaCreacion).toLocaleString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default App;
