import { useState } from 'react';

export default function TicketForm() {

    const [tipo, setTipo] = useState('CONSULTA');
    const [prioridadManual, setPrioridadManual] = useState(1);
    const [usuario, setUsuario] = useState('');

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
    return (
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

        </div>)
}