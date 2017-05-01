using Servicio.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Servicio.Controllers
{
    public class ResidencialController : ApiController
    {

        private LinqDataContext linq = Conector.getLinqContext();

        //api/Residencial

        [HttpGet]
        public List<Residencial> GetResidenciales()
        {
            List<Residencial> resultado = new List<Residencial>();
            var consulta = (from residencial in linq.RESIDENCIAL
                            select residencial);
            foreach (var fila in consulta)
            {
                resultado.Add(new Residencial()
                {
                    Id = fila.ID,
                    Nombre = fila.NOMBRE,
                    Direccion = fila.DIRECCION
                });
            }
            return resultado;
        }


    }
}
