import { useState, useEffect } from 'react';

export default function Table() {
    const [count, setCount] = useState([]);

    useEffect(() => {
        fetch('http://localhost:5000/api/v1/solicitudes/priorizadas')
            .then(response => response.json())
            .then(data => setCount(data))
            .catch(error => console.error('Error fetching tickets:', error));
    }, []);

return(<div className='mainContainerTable'>
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
    )

}
