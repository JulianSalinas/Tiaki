using Servicio.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Servicio.Controllers
{
    public class GrupoController : ApiController
    {

        private LinqDataContext linq = Conector.getLinqContext();

        [HttpGet]
        public Grupo GetGrupo(string turno) {

            if (turno.Equals("Actual"))
            {
                return GetGrupoActual(turno).ElementAt(0);
            }
            else
            {
                return GetGrupoSiguiente(turno).ElementAt(0);
            }
        }

        [HttpGet]
        public List<Grupo> GetGrupoActual(string actual) {

            int dia = (int)DateTime.Now.DayOfWeek;
            int hora = DateTime.Now.Hour;
            List<Grupo> resultado = new List<Grupo>();

            var consulta = (from g in linq.GRUPO
                            where g.DIA == dia
                            && g.HINICIO <= hora
                            && hora <= (g.HINICIO + g.DURACION)
                            select g);

            foreach (var fila in consulta)
            {
                resultado.Add(new Grupo()
                {
                    Id = fila.ID,
                    Dia = fila.DIA,
                    Duracion = (int)fila.DURACION,
                    Hinicio = fila.HINICIO
                });
            }

            return resultado;
        }

        [HttpGet]
        public List<Grupo> GetGrupoSiguiente(string siguiente) {
            Grupo actual = GetGrupoActual(siguiente).ElementAt(0);
            int horaFin = actual.Hinicio + actual.Duracion;
            int dia = actual.Dia + (horaFin / 24);
            int hora = horaFin % 24;
            List<Grupo> resultado = new List<Grupo>();

            var consulta = (from g in linq.GRUPO
                            where (g.DIA == dia) 
                            && g.HINICIO == hora
                            && hora <= (g.HINICIO + g.DURACION)
                            select g);

            foreach (var fila in consulta)
            {
                resultado.Add(new Grupo()
                {
                    Id = fila.ID,
                    Dia = fila.DIA,
                    Duracion = (int)fila.DURACION,
                    Hinicio = fila.HINICIO
                });
            }

            return resultado;
        }

    }
}
