export default function Footer(props) {
  return (
    <div className="fixed bottom-0 w-full  px-16 py-5 flex justify-between items-center">
      <span>©2024 Zahabiya. All rights reserved.</span>
      <span className="cursor-pointer hover:underline">
        Terms and Conditions
      </span>
      <span className="cursor-pointer hover:underline">Privacy Policy</span>
    </div>
  );
}
