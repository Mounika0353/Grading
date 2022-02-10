import { useState } from "react";
import axios from "axios";

const units = new Set([
	"celsius",
	"fahrenheit",
	"kelvin",
	"rankine",
	"cubic inches",
	"cubic feet",
	"liter",
	"tablespoon",
	"cup",
	"gallon",
]);

const Grading = () => {
	const [data, setData] = useState([
		{
			inputValue: "",
			inputUnit: "",
			targetUnit: "",
			targetValue: "",
			studentResponse: "",
		},
	]);

	const getTargetValue = async ({ inputValue, inputUnit, targetUnit }) =>
		axios.get(
			`http://localhost:8080/convert?inputValue=${inputValue}&inputUnit=${inputUnit}&outputUnit=${targetUnit}`
		);

	const handleAddRow = () => {
		setData([
			...data,
			{
				inputValue: "",
				inputUnit: "",
				targetUnit: "",
				targetValue: "",
				studentResponse: "",
			},
		]);
	};

	const onChange = async (field, index, value) => {
		if (
			field === "inputValue" ||
			field === "inputUnit" ||
			field === "targetUnit"
		) {
			const variables = {
				inputValue:
					field === "inputValue" ? value.toLowerCase() : data[index].inputValue,
				inputUnit:
					field === "inputUnit" ? value.toLowerCase() : data[index].inputUnit,
				targetUnit:
					field === "targetUnit" ? value.toLowerCase() : data[index].targetUnit,
			};

			if (
				units.has(variables.inputUnit.toLowerCase()) &&
				units.has(variables.targetUnit.toLowerCase())
			) {
				let response = "";
				try {
					response = await getTargetValue(variables);

					response = response.data;
				} catch (e) {
					response = "";
				}
				console.log("hello");
				setData(
					data.map((row, i) =>
						i === index
							? { ...row, [field]: value.toLowerCase(), targetValue: response }
							: row
					)
				);
			} else {
				setData(
					data.map((row, i) =>
						i === index ? { ...row, [field]: value.toLowerCase() } : row
					)
				);
			}
		} else {
			setData(
				data.map((row, i) =>
					i === index ? { ...row, [field]: value.toLowerCase() } : row
				)
			);
		}
	};

	return (
		<>
			<table>
				<thead>
					<tr>
						<th>Input Numerical Value</th>
						<th>Input Unit of Measure</th>
						<th>Target Unit of Measure</th>
						<th>Student Response</th>
						<th>Result</th>
					</tr>
				</thead>
				<tbody>
					{data.map(
						(
							{
								inputValue,
								inputUnit,
								targetUnit,
								targetValue,
								studentResponse,
							},
							index
						) => (
							<tr key={index}>
								<td>
									<input
										type="number"
										value={inputValue}
										onChange={(event) =>
											onChange("inputValue", index, event.target.value)
										}
									/>
								</td>
								<td>
									<input
										type="text"
										value={inputUnit}
										onChange={(event) =>
											onChange("inputUnit", index, event.target.value)
										}
										style={{ color: units.has(inputUnit) ? "green" : "red" }}
									/>
								</td>
								<td>
									<input
										type="text"
										value={targetUnit}
										onChange={(event) =>
											onChange("targetUnit", index, event.target.value)
										}
										style={{ color: units.has(targetUnit) ? "green" : "red" }}
									/>
								</td>
								<td>
									<input
										type="number"
										value={studentResponse}
										onChange={(event) =>
											onChange("studentResponse", index, event.target.value)
										}
									/>
								</td>
								<td>
									{parseFloat(targetValue).toPrecision(4) ===
									parseFloat(studentResponse).toPrecision(4) ? (
										<span style={{ color: "green" }}>Correct</span>
									) : (
										<span style={{ color: "red" }}>Incorrect</span>
									)}
								</td>
							</tr>
						)
					)}
				</tbody>
			</table>
			<div
				style={{
					padding: "8px 8px",
					display: "flex",
					justifyContent: "flex-end",
					width: "100%",
				}}
			>
				<button onClick={handleAddRow}>Add Row</button>
			</div>
		</>
	);
};

export default Grading;
