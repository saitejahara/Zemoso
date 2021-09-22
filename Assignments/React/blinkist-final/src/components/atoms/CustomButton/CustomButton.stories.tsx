import CustomButton from "./CustomButton";

export default {
  title: "Custom Button",
  component: CustomButton,
};

export const CustomButtonComponent = () => (
  <CustomButton
    onClick={() => console.log("clicked the custom button")}
    style={{ textTransform: "capitalize", fontSize: "larger", color: "black" }}
    disabled={false}
    name="Custom Button Component"
  ></CustomButton>
);
