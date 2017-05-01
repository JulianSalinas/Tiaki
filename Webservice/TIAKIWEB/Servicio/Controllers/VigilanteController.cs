using Servicio.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Servicio.Controllers
{
    public class VigilanteController : ApiController
    {

        private LinqDataContext linq = Conector.getLinqContext();
        private GrupoController grupos = new GrupoController();

        //api/
        [HttpGet]
        public List<Vigilante> GetVigilantes(string turno)
        {
            List<Vigilante> resultado = new List<Vigilante>();
            var consulta = (from vigilante in linq.VIGILANTE
                            select vigilante);

            if (!turno.Equals("Todos"))
            {
                Grupo grupo = grupos.GetGrupo(turno);
                consulta = (from vigilante in consulta
                            where (vigilante.GRUPO == grupo.Id
                            || vigilante.GRUPO == "G")
                            && vigilante.ESTADO == "Activo"
                            select vigilante);
            }

            foreach (var fila in consulta)
            {
                resultado.Add(new Vigilante()
                {
                    Id = fila.ID,
                    Nombre = fila.NOMBRE,
                    Telefono = fila.TELEFONO,
                    Civil = fila.CIVIL,
                    Estado = fila.ESTADO,
                    Grupo = fila.GRUPO,
                    Residencial = new Residencial() {
                        Id = fila.RESIDENCIAL1.ID,
                        Nombre = fila.RESIDENCIAL1.NOMBRE,
                        Direccion = fila.RESIDENCIAL1.DIRECCION
                    },
                    PrecioHora = (float) fila.PRECIOHORA,
                    ExtraHora = (float) fila.EXTRAHORA,
                    HorasTrabajadas = (int) fila.HORASTRABAJADAS,
                    ExtrasTrabajadas = (int) fila.EXTRASTRABAJADAS  
                });
            }
            return resultado;
        }

    }
}
