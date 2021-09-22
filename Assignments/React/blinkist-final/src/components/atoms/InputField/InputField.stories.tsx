//import TextField from "@material-ui/core/TextField";
import TextField from "./InputField";

export default {
  title: "InputField",
  component: TextField,
};

export const Standard = () => (
  <TextField id="standard-basic" label="Standard" />
);
export const Filled = () => (
  <TextField id="filled-basic" label="Filled" variant="filled" />
);
export const Outlined = () => (
  <TextField id="outlined-basic" label="Outlined" variant="outlined" />
);
