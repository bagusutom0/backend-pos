export default function AddProduct() {
  const onSubmitForm = (data) => {
    console.log(data);
  };

  return (
    <div>
      <h1>Add Product</h1>
      <form onSubmit={onSubmitForm}>
        <div>
          <label htmlFor="name"></label>
        </div>
      </form>
    </div>
  );
}
