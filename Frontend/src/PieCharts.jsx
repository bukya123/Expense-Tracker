import { Pie } from 'react-chartjs-2'
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from 'chart.js';
import { useSelector } from 'react-redux';

ChartJS.register(ArcElement, Tooltip, Legend);
const PieCharts = () => {
    const {expenses}=useSelector((state)=>state.expenses)
    const data = {
    labels: expenses && expenses.map(item => item.categoryName),
    datasets: [
      {
        data: expenses && expenses.map(item => item.amount),
        backgroundColor: ["#8AD1C2", "#9F8AD1", "#D18A99", "#BCD18A", "#D1C28A"],
        hoverOffset: 4,
      },
    ],
  };

  return (
    <div className='w-1/3 h-1/3 flex justify-center'>
        <Pie data={data} />
    </div>
    
  )
    
}

export default PieCharts;