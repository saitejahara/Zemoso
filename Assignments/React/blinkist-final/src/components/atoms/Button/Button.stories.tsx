import Button from "./Button";

export default {
  title: "Button",
  component: Button,
};

export const Primary = () => (
  <Button
    variant="contained"
    color="primary"
    size="medium"
    onClick={() => console.log("you clicked me")}
    name="Primary"
  ></Button>
);

export const Secondary = () => (
  <Button
    variant="contained"
    color="secondary"
    size="medium"
    onClick={() => console.log("you clicked me")}
    name="Secondary"
  ></Button>
);

export const Small = () => (
  <Button
    variant="contained"
    color="primary"
    size="small"
    onClick={() => console.log("you clicked me")}
    name="Small"
  ></Button>
);

export const Medium = () => (
  <Button
    variant="contained"
    color="primary"
    size="medium"
    onClick={() => console.log("you clicked me")}
    name="Medium"
  ></Button>
);

export const Large = () => (
  <Button
    variant="contained"
    color="primary"
    size="large"
    onClick={() => console.log("you clicked me")}
    name="Large"
  ></Button>
);

export const Disabled = () => (
  <Button
    variant="contained"
    color="primary"
    size="large"
    disabled={true}
    name="Disabled"
  ></Button>
);
