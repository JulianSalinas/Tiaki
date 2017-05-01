using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Servicio.Models
{
    public class Grupo
    {

        private string _id;
        private int _dia;
        private int _hinicio;
        private int _duracion;

        public string Id
        {
            get
            {
                return _id;
            }

            set
            {
                _id = value;
            }
        }

        public int Dia
        {
            get
            {
                return _dia;
            }

            set
            {
                _dia = value;
            }
        }

        public int Hinicio
        {
            get
            {
                return _hinicio;
            }

            set
            {
                _hinicio = value;
            }
        }

        public int Duracion
        {
            get
            {
                return _duracion;
            }

            set
            {
                _duracion = value;
            }
        }
    }
}